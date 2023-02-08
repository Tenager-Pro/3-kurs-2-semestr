import sys
from PyQt5 import uic
from PyQt5 import QtWidgets
from PyQt5.QtWidgets import QDialog, QApplication
from PyQt5.uic import loadUi
from re import sub
from decimal import Decimal
from PyQt5.QtWidgets import QMessageBox
from Authorithation import *
from Registration import *
from Menu import *
from TranslateInAccount import *
from TranslateInYourAccount import *
from DialogExitWindow import *
from CreateAccount import *
from Money import *
from Converting import *
from FunctionMoney import *
from FunctionMenu import *
from Account import *
from FunctionRegistration import check
from datetime import date
from work_db import get_data_user, get_data_account
import regex




# Class
class DialogExitWindow(QtWidgets.QDialog):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_DialogExitWindow()
        self.ui.setupUi(self)
        self.ui.push_button_ok.clicked.connect(self.ok)
        self.ui.push_button_cancel.clicked.connect(self.cancel)

    def ok(self):
        autho.show()
        menu.setEnabled(True)
        menu.close()
        dialog_exit.close()

    def cancel(self):
        dialog_exit.close()
        menu.setEnabled(True)

class Money(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_Money()
        self.id=0
        self.summ=0.0
        self.account=()
        self.data_account=()
        self.ui.setupUi(self)
        self.ui.chanel_button.clicked.connect(self.chanel_button)
        self.ui.add_accounting_button.clicked.connect(self.add_account)
        self.ui.name_account.currentTextChanged.connect(self.set_new_balance)

    def add_account_combo_box(self):
        self.data_account=get_account_user_id(self.id)
        for account in self.data_account:
            self.ui.name_account.addItem(account[0])

    def set_new_balance(self, text):
        for account in self.data_account:
            if account[0] == text:
                self.account=account
                self.ui.balance.setText(account[1])
    def add_account(self):
        print(self.summ)
        print(convert_money_in_decimal(self.ui.balance.text()))
        if self.summ>convert_money_in_decimal(self.ui.balance.text()):
            msg = QMessageBox()
            msg.setIcon(QMessageBox.Critical)
            msg.setText("Открытие счета:")
            msg.setInformativeText('Не достаточно средств на данном счете')
            msg.setWindowTitle("Error")
            msg.exec_()
        else:
            if set_data_account():
                msg = QMessageBox()
                msg.setIcon(QMessageBox.Information)
                msg.setText("Открытие счета:")
                msg.setInformativeText('Поздравляю! Счет открыт')
                msg.setWindowTitle("Info")
                msg.exec_()
                menu.show()
                money.close()
    def chanel_button(self):
        create_account.show()
        money.close()


class TranslateInAccount(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_TranslateInAccount()
        self.ui.setupUi(self)
        self.ui.translate_in_your_account.clicked.connect(self.translate_in_your_account_open)

    def translate_in_your_account_open(self):
        translate_in_your_account.show()
        translate_in_account.close()


class TranslateInYourAccount(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_TranslateInYourAccount()
        self.ui.setupUi(self)
        self.ui.translate_in_account.clicked.connect(self.translate_in_account_open)

    def translate_in_account_open(self):
        translate_in_account.show()
        translate_in_your_account.close()

class CreateAccount(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_CreateAccount()
        self.ui.setupUi(self)
        self.data_account=()
        self.account = ()
        self.id=0
        self.ui.create_account_button.clicked.connect(self.money)
        self.ui.chanel_button.clicked.connect(self.chanel_menu)
        self.ui.name_account.currentTextChanged.connect(self.set_new_data)
        self.ui.min_sum.textChanged.connect(self.calculating_income)

    def calculating_income(self):
        if self.account:
            if self.ui.check_money_account.isChecked():
                pass
            else:
                value=convert_money_in_decimal(self.ui.min_sum.text())
                print(Decimal(self.account[3]/12*self.account[2])+100)
                self.ui.income.setText(str(round((value*Decimal(0.01*((self.account[3]/12*self.account[2])+100))),2)))
    def set_new_data(self, text):
        for account in self.data_account:
            if account[6] == text:
                self.account = account
                self.ui.min_sum.setText(str(account[1]))
                self.ui.count_month.setText(str(account[2])+ ' мес.')
                self.ui.percentage.setText(str(account[3])+'%')
                self.ui.is_replenishment.setChecked(account[4])
                self.ui.is_withdrawal.setChecked(account[5])
                self.calculating_income()

    def add_account(self, data_account):
        self.data_account=data_account
        for account in data_account:
            self.ui.name_account.addItem(account[6])


    def money(self):
        money.id=self.id
        money.add_account_combo_box()
        money.summ = convert_money_in_decimal(self.ui.min_sum.text())
        money.show()
        create_account.close()
    def chanel_menu(self):
        menu.show()
        create_account.close()


class Menu(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_Menu()
        self.ui.setupUi(self)
        self.name = "Name"
        self.id = 0
        self.create_date = date.today()
        self.ui.push_button_exit.clicked.connect(self.exit)
        self.ui.add_accounting_button.clicked.connect(self.add_accouting)
        self.ui.translate_button.clicked.connect(self.translate)
        #self.ui.list_account.currentTextChanged.connect(self.information_about_account) на будущее можно сделать вывод информации о вкладе в визарде



    def add_item_account_widget(self):
        list_account=get_list_account(self.id)
        for account in list_account:
            str_account = "Название: " + account[0] + "\nНомер счета: " + account[1] +"\nБаланс: " + account[2]
            self.ui.list_account.addItem(str_account)

    def translate(self):
        translate_in_your_account.show()
    def add_accouting(self):
        create_account.id = self.id
        create_account.add_account(get_data_account())
        create_account.show()
        menu.hide()

    def exit(self):
        dialog_exit.show()
        menu.setEnabled(False)

    def set_name(self, name):
        self.ui.label_name.setText("Добро пожаловать, " + name + ",")
        self.name = name

    def set_id(self, id):
        self.id = id






class Authorithation(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_Authorithation()
        self.ui.setupUi(self)
        self.ui.push_button_auth.clicked.connect(lambda: authorithation_people(self.ui.line_edit_phone.text(),
                                                                        self.ui.line_edit_password.text()))
        self.ui.push_button_open_reg.clicked.connect(self.open_reg)

    def open_reg(self):
        reg.show()
        autho.close()


class Registration(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_Registration()
        self.ui.setupUi(self)
        self.ui.push_button_open_authorithation.clicked.connect(self.open_autho)
        self.ui.push_button_reg.clicked.connect(lambda: check(self.ui.first_name.text(), self.ui.last_name.text(),
                                                              self.ui.email.text(), self.ui.phone.text(),
                                                              self.ui.password.text(), self.ui.conf_password.text()))

    def open_autho(self):
        autho.show()
        reg.close()


# Function
def authorithation_people(phone, password):
    if phone:
        rule = regex.compile(r'(^[+0-9]{1,3})*([0-9]{10,11}$)')
        if rule.search(phone):
            user = get_data_user(phone, password)
            if user != []:
                menu.set_name(user[1])
                menu.set_id(user[0])
                menu.add_item_account_widget()
                menu.show()
                autho.close()

            else:
                msg = QMessageBox()
                msg.setIcon(QMessageBox.Critical)
                msg.setText("Авторизация:")
                msg.setInformativeText('Пользователя с таким номером или паролем не существует')
                msg.setWindowTitle("Error")
                msg.exec_()
        else:
            msg = QMessageBox()
            msg.setIcon(QMessageBox.Critical)
            msg.setText("Авторизация:")
            msg.setInformativeText('Введите коректный номер телефона')
            msg.setWindowTitle("Error")
            msg.exec_()


# Main
if __name__ == "__main__":
    name = ""
    app = QtWidgets.QApplication(sys.argv)
    reg = Registration()
    money= Money()
    create_account=CreateAccount()
    translate_in_account = TranslateInAccount()
    translate_in_your_account = TranslateInYourAccount()
    dialog_exit = DialogExitWindow()
    autho = Authorithation()
    menu = Menu()
    autho.show()
    sys.exit(app.exec_())

# form.action.clicked.connect()

# form.push_button_reg.clicked.connect(lambda: check(form.line_edit_phone_2.text(),
# form.line_edit_password_2.text(),
# form.line_edit_password_3.text()))
# Добавление qr-code
# pixmap = QPixmap('site.png')
# form.label.setPixmap(pixmap)
