from PyQt5.QtWidgets import QMessageBox
from work_db import check_phone_in_db, set_data_user,set_data_account,get_id_user
from User import User
import regex
from Account import *
from datetime import date


def check(first_name, last_name, email, phone, password, password_check):
    if phone:
        rule = regex.compile(r'(^[+0-9]{1,3})*([0-9]{10,11}$)')
        if rule.search(phone):
            if password == password_check:
                registration(first_name, last_name, email, phone, password)
            else:
                msg = QMessageBox()
                msg.setIcon(QMessageBox.Critical)
                msg.setText("Error")
                msg.setInformativeText('Пароли не совпадают')
                msg.setWindowTitle("Error")
                msg.exec_()
        else:
            msg = QMessageBox()
            msg.setIcon(QMessageBox.Critical)
            msg.setText("Error")
            msg.setInformativeText('Введите телефон правильно')
            msg.setWindowTitle("Error")
            msg.exec_()
    else:
        msg = QMessageBox()
        msg.setIcon(QMessageBox.Critical)
        msg.setText("Error")
        msg.setInformativeText('Введите телефон')
        msg.setWindowTitle("Error")
        msg.exec_()


def registration(first_name, last_name, email, phone, password):
    if check_phone_in_db(phone):
        newUser = User(first_name, last_name, email, phone, password)
        set_data_user(newUser)
        account = Account(get_id_user(phone), date.today(), 0, 4)
        set_data_account(account)
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
