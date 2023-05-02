#include <stdio.h>
#include <winsock2.h> // Включаем использование сокетов
#include <windows.h>
#include <memory.h>
#include <string.h>
#pragma comment(lib, "WSock32.lib") // Используем эту библиотеку
#pragma comment (lib, "mswsock.lib")

#define PORT 15150    // порт сервера
#define Line "File is recivied"
#define Nsize 1024

int main(int argc, char* argv[])
{
    char buff[Nsize];

    printf("Server start working...\n");

    //подключение библиотеки 
    WSADATA WsaData;
    if (WSAStartup(0x0202, &WsaData))
    {
        printf("Winsock cannot be started\r\n");
        return false;
    }
    //создание сокета
    SOCKET my_sock;
    my_sock = socket(AF_INET, SOCK_DGRAM, 0);
    if (my_sock == INVALID_SOCKET)
    {
        printf("Socket() error: %d\n", WSAGetLastError());
        WSACleanup();
        return -1;
    }

    //связывание сокета с локальным адресом 
    sockaddr_in local_addr;
    memset(&local_addr, 0, sizeof(sockaddr_in));
    local_addr.sin_family = AF_INET;
    local_addr.sin_addr.s_addr = INADDR_ANY;
    local_addr.sin_port = htons(PORT);

    if (bind(my_sock, (sockaddr*)&local_addr, sizeof(local_addr)))
    {
        printf("bind error: %d\n", WSAGetLastError());
        closesocket(my_sock);
        WSACleanup();
        return -1;
    }

    //обработка пакетов, присланных клиентами
    while (1)
    {
        char tBuf[53];
        sockaddr_in client_addr;
        memset(&client_addr, 0, sizeof(sockaddr_in));
        int client_addr_size = sizeof(sockaddr_in);
        int bsize = recvfrom(my_sock, tBuf, Nsize * sizeof(char), 0, (sockaddr*)&client_addr, &client_addr_size);
        if (bsize == SOCKET_ERROR)
        {
            printf("recvfrom() error: %d\n", WSAGetLastError());
            break;
        }

        // Определяем IP-адрес клиента и прочие атрибуты
        HOSTENT* hst;
        hst = gethostbyaddr((char*)&client_addr.sin_addr, 4, AF_INET);
        printf("+%s [%s:%d] new DATAGRAM!\n", (hst) ? hst->h_name : "Unknown host", inet_ntoa(client_addr.sin_addr), ntohs(client_addr.sin_port));

        char blockN[3];
        memcpy((void*)blockN, (void*)tBuf, 3);
        memcpy((void*)buff, (void*)(tBuf + 3), 50); //выделztv содержимое buff  
        int N = atoi(blockN); //определяем N
        printf("\nNumber of block is:%d\n", N);

        // добавление завершающего нуля
        buff[bsize - 3] = 0;

        // Вывод на экран 
        printf("Client=>Server:%s\n", buff);

        FILE* file;
        char* file_name = buff;
        file = fopen(file_name, "r");
        if (file != 0)
        {
            char buffer[Nsize + 1];
            fseek(file, 0, 2);
            int filesize = ftell(file);
            int filemarker = 0;
            fseek(file, Nsize * N, 0);
            int szee = Nsize;

            while (szee == Nsize)
            {
                printf("Recieve file - ");
                memset(buffer, 0, Nsize);
                szee = fread(buffer, sizeof(char), Nsize, file);

                sendto(my_sock, &buffer[0], szee, 0,
                    (sockaddr*)&client_addr, sizeof(client_addr));
                printf("filemarker = %d of filesize = %d \n", filemarker, filesize);
                filemarker += szee;
            }
            char* line = new char[30];
            strcpy(line, "File is recivied");
            sendto(my_sock, &line[0], strlen(&line[0]), 0,
                (sockaddr*)&client_addr, sizeof(client_addr));

            fclose(file);
        }
        else
        {
            printf("File not found !!!");
        }
    }
    system("PAUSE");
    return 0;
}