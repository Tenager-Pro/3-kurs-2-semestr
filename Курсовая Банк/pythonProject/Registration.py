from PyQt5.QtWidgets import QMessageBox
from work_db import get_data_user
def check(phone, password, password_check):
    if password==password_check:
        registration(phone,password)
    else:
        msg = QMessageBox()
        msg.setIcon(QMessageBox.Critical)
        msg.setText("Error")
        msg.setInformativeText('Пароли не совпадают')
        msg.setWindowTitle("Error")
        msg.exec_()

def registration(phone,password):

    if get_data_user(phone):
        msg = QMessageBox()
        msg.setIcon(QMessageBox.Information)
        msg.setText("Регистрация:")
        msg.setInformativeText('Регистрация прошла успешно')
        msg.setWindowTitle("Регистрация")
        msg.exec_()
    else:
        msg = QMessageBox()
        msg.setIcon(QMessageBox.Critical)
        msg.setText("Регистрация:")
        msg.setInformativeText('Пользователь с таким номером уже существует')
        msg.setWindowTitle("Error")
        msg.exec_()



