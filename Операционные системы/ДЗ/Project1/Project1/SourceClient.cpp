#include <stdio.h>
#include <string.h>
#include <winsock2.h> // ¬ключаем использование сокетов
#include <windows.h>
#include <memory.h>
#include <string.h>

#pragma comment(lib, "WSock32.lib") // »спользуем эту библиотеку
#pragma comment (lib, "mswsock.lib")

#define PORT 15150
#define SERVERADDR "127.0.0.1"
#define CLIENT_FILE "input.txt" //файл на клиенте
#define Line "File is recivied"
int p;

#define Nsize 1024
int main(int argc, char* argv[])
{
    char buffer[30 * Nsize];
    char buff[Nsize + 1];
    printf("Client start working...\n");

    //иницилизаци€ библиотеки Winsocks
    WSADATA WsaData;
    if (WSAStartup(0x0202, &WsaData))
    {
        printf("Winsock cannot be started\r\n");
        return false;
    }

    //открытие сокета
    SOCKET my_sock = socket(AF_INET, SOCK_DGRAM, 0);
    if (my_sock == INVALID_SOCKET)
    {
        printf("socket() error: %d\n", WSAGetLastError());
        WSACleanup();
        return -1;
    }

    //обмен сообщений с сервером
    // установка возможности широковещательного адреса
    int i = 1;
    if (setsockopt(my_sock, SOL_SOCKET, SO_BROADCAST, (char*)&i, sizeof(i)) == -1)
    {
        printf("Error setting broadcast socket\n");
        WSACleanup();
        return -1;
    }
    HOSTENT* hst;
    sockaddr_in dest_addr;
    memset(&dest_addr, 0, sizeof(sockaddr_in));
    dest_addr.sin_family = AF_INET;
    dest_addr.sin_port = htons(PORT);


    // определение IP-адреса узла
    if (inet_addr(SERVERADDR))
        dest_addr.sin_addr.s_addr = inet_addr(SERVERADDR);
    else
        if (hst = gethostbyname(SERVERADDR))
            dest_addr.sin_addr.s_addr = ((unsigned long**)
                hst->h_addr_list)[0][0];
        else
        {
            printf("Unknown host: %d\n", WSAGetLastError());
            closesocket(my_sock);
            WSACleanup();
            return -1;
        }


    while (1)
    {
        // чтение сообщени€ с клавиатуры
        printf("\nClient=>Server:");
        scanf("%s", buff);
        if (!strcmp(buff, "quit\n")) break;

        int N = 30;
        printf("Number of block is:");
        scanf("%d", &N);
        char blockN[3];
        sprintf(blockN, "%3d", N);
        char tBuf[53];
        memcpy((void*)tBuf, (void*)blockN, 3); // в первые 3 символа пишем N
        memcpy((void*)(tBuf + 3), (void*)buff, 50); // пишем в tBuf содержимое buff

        // ѕередача сообщений на сервер
        sendto(my_sock, tBuf, strlen(tBuf), 0, (sockaddr*)&dest_addr, sizeof(sockaddr_in));

        // ѕрием сообщени€ с сервера
        sockaddr_in server_addr;
        int server_addr_size = sizeof(server_addr);
        char* line = new char[30];
        strcpy(line, "File is recivied");
        p = 0;

        while (*buff != *line)
        {
            memset(buff, 0, Nsize);
            int n = recvfrom(my_sock, &buff[0], Nsize + 1, 0,
                (sockaddr*)&server_addr, &server_addr_size);

            printf("Was recieved bytes %d\n", n);

            if (n == SOCKET_ERROR)
            {
                printf("recvfrom() error:"\
                    "%d\n", WSAGetLastError());
                closesocket(my_sock);
                WSACleanup();
                return -1;
            }
            buff[n] = 0;
            if (*buff != *line)
            {
                for (int i = 0; i < strlen(buff); i++)
                {
                    buffer[p + i] = buff[i];
                }

                p += n;
                buffer[p] = 0;
            }
        }

        // ¬ывод прин€того с сервера сообщени€ об успешной операции на экран
        printf("Client<=Server:%s", &buff[0]);

        FILE* file;
        char* file_name = new char[30];
        strcpy(line, "input.txt");
        file = fopen(file_name, "w");
        fputs(buffer, file);
        memset(buffer, 0, 30 * Nsize * sizeof(char));
        fclose(file);
    }

    //выход
    closesocket(my_sock);
    WSACleanup();

    return 0;
}