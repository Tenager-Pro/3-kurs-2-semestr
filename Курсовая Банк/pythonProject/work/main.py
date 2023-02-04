import sys
from PyQt5 import uic
from PyQt5 import QtWidgets
from CreateNewAccount import Ui_CreateAccount
from SearchPeople import Ui_SearcPeopleWindow
from PyQt5.QtWidgets import QDialog, QApplication
from PyQt5.uic import loadUi
from PyQt5.QtWidgets import QMessageBox
from work_db import *

class CreateNewAccount(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_CreateAccount()
        self.ui.setupUi(self)
        self.ui.chanel_button.clicked.connect(lambda: self.chanel_button())
        self.ui.create_account_button.clicked.connect(lambda: self.create_new_account(
            self.ui.name_accounting.text(), self.ui.count_month.text(), self.ui.percentage.text(),
            self.ui.min_sum.text(), self.ui.is_replenishment.isChecked(), self.ui.is_withdrawal.isChecked()
        ))

    def chanel_button(self):
        check_people.show()
        create_new_account.close()

    def create_new_account(self, name_account, count_month, percentage, min_sum, is_replenishment, is_withdrawal):
        set_data_account(name_account, count_month, percentage, min_sum, is_replenishment, is_withdrawal)






class SearchPeople(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_SearcPeopleWindow()
        self.ui.setupUi(self)
        self.ui.search_button.clicked.connect(lambda: find_people_click(self.ui.search_field.text()))
        self.ui.search_field.textChanged[str].connect(lambda: find_people(self.ui.search_field.text()))
        self.ui.create_account.addAction("Новый счет",lambda: self.open_create_new_account())

    def set_people(self, people_list):
        pass

    def open_create_new_account(self):
        create_new_account.show()
        check_people.close()




def find_people(search_phone):
    if search_phone:
        people_list = get_data_user(search_phone)
        if people_list:
            print(people_list)
            check_people.set_people(people_list)


def find_people_click(search_phone):
    people_list = get_data_user(search_phone)
    if people_list:
        print(people_list)
        check_people.set_people(people_list)
    else:
        msg = QMessageBox()
        msg.setIcon(QMessageBox.Critical)
        msg.setText("Error")
        msg.setInformativeText('Пользователи не найдены')
        msg.setWindowTitle("Error")
        msg.exec_()

if __name__ == "__main__":
    name=""
    app = QtWidgets.QApplication(sys.argv)
    create_new_account = CreateNewAccount()
    check_people = SearchPeople()
    check_people.show()
    sys.exit(app.exec_())

