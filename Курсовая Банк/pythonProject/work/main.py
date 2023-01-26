import sys
from PyQt5 import uic
from PyQt5 import QtWidgets
from SearchPeople import Ui_SearcPeopleWindow
from PyQt5.QtWidgets import QDialog, QApplication
from PyQt5.uic import loadUi
from PyQt5.QtWidgets import QMessageBox
from work_db import get_data_user

class SearchPeople(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_SearcPeopleWindow()
        self.ui.setupUi(self)
        self.ui.search_button.clicked.connect(lambda: find_people_click(self.ui.search_field.text()))
        self.ui.search_field.textChanged[str].connect(lambda: find_people(self.ui.search_field.text()))

    def set_people(self, people_list):
        pass

def find_people(search_phone):
    if search_phone:
        people_list = get_data_user(search_phone)
        if people_list:
            print(people_list)
            checkPeople.set_people(people_list)


def find_people_click(search_phone):
    people_list = get_data_user(search_phone)
    if people_list:
        print(people_list)
        checkPeople.set_people(people_list)
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
    checkPeople = SearchPeople()
    checkPeople.show()
    sys.exit(app.exec_())

