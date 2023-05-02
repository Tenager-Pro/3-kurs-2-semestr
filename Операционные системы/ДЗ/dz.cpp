#include <iostream>
#include <conio.h>
#include <fstream>

using namespace std;

int main()
{

    int j = 0, n, k, p = 1, i;
    cout << "Input number (n>=2): ";
    cin >> n;
    std::ofstream out;     // поток для записи
    out.open("hello.txt"); // открываем файл для записи
    if (out.is_open())
    {
        out << "\nk:";
        k = n;
        p = 2;
        while (k > 1)
        {
            if (k % p == 0)
            {
                out << " " << p;
                k /= p;
                p = 2;
            }
            else
                ++p;
        }
    }
    out.close();
    std::cout << "File has been written" << std::endl;

    k = n;
    p = 2;
    while (k > 1)
    {
        if (k % p == 0)
        {
            cout << " " << p;
            k /= p;
            p = 2;
        }
        else
            ++p;
    }

    cout << "\n1:";
    k = n;
    p = 2;
    i = INT_MIN;
    while (k > 1)
    {
        if (k % p == 0)
        {
            if (p > i)
            {
                i = p;
                cout << " " << p;
            }
            k /= p;
            p = 2;
        }
        else
            ++p;
    }
    system("pause");
    return 0;
}