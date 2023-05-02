#include <iostream>
#include <fstream>
#include <string>



using namespace std;

int main()
{
    int j = 0, n, k, p = 1, i, num;
    cout << "1 - In file, 2 in exe\n";
    cin >> num;
    if(num == 1){
        std::string line;

        std::ifstream in("input.txt"); // окрываем файл для чтения
        if (in.is_open())
        {
            while (getline(in, line))
            {
                std::cout << line << std::endl;
                n = std::stoi(line);
            }
        }
        in.close();     // закрываем файл
       
    }
    else {
        cout << "Input number (n>=2): ";
        cin >> n;
    }
    
    std::ofstream out;     // поток для записи
    out.open("output.txt"); // открываем файл для записи
    if (out.is_open())
    {
        out << "input: " << n << "\n";
        cout << "number: ";
        out << "number: ";
        k = n;
        p = 2;
        while (k > 1)
        {
            if (k % p == 0)
            {
                cout << " " << p;
                out << " " << p;
                k /= p;
                p = 2;
            }
            else
                ++p;
        }
    }
    out.close();
    std::cout << "\nFile has been written" << std::endl;

    system("pause");
    return 0;
}