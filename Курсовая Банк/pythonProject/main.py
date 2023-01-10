import sys
from PyQt5 import uic
from PyQt5 import QtWidgets
from PyQt5.QtWidgets import QDialog, QApplication
from PyQt5.uic import loadUi
from PyQt5.QtWidgets import QMessageBox
from Authorithation import *
from Registration import *
from Menu import *
from DialogExitWindow import *
from FunctionRegistration import check
from work_db import get_data_user

class DialogExitWindow(QtWidgets.QDialog):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui=Ui_DialogExitWindow()
        self.ui.setupUi(self)
        self.ui.push_button_ok.clicked.connect(self.ok)
        self.ui.push_button_cancel.clicked.connect(self.cancel)

    def ok(self):
        autho.show()
        menu.close()
        dialog_exit.close()


    def cancel(self):
        dialog_exit.close()
        menu.setEnabled(True)



class Menu(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_Menu()
        self.ui.setupUi(self)
        self.name="Name"
        self.ui.push_button_exit.clicked.connect(self.exit)

    def exit(self):
        dialog_exit.show()
        menu.setEnabled(False)
    def set_name(self, name):
        self.ui.label_name.setText(name+",")
        self.name = name


class Authorithation(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_Authorithation()
        self.ui.setupUi(self)
        self.ui.push_button_auth.clicked.connect(lambda: authorithation(self.ui.line_edit_phone.text(),
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
        self.ui.push_button_reg.clicked.connect(lambda:  check(self.ui.first_name.text(), self.ui.last_name.text(),
                                                               self.ui.email.text(), self.ui.phone.text(),
                                                               self.ui.password.text(), self.ui.conf_password.text()))

    def open_autho(self):
        autho.show()
        reg.close()


def authorithation(phone, password):
    user=get_data_user(phone,password)
    if user!=[]:
        menu.set_name(user[1])
        menu.show()

        autho.close()

    else:
        msg = QMessageBox()
        msg.setIcon(QMessageBox.Critical)
        msg.setText("Авторизация:")
        msg.setInformativeText('Пользователя с таким номером или паролем не существует')
        msg.setWindowTitle("Error")
        msg.exec_()




if __name__ == "__main__":
    name=""
    app = QtWidgets.QApplication(sys.argv)
    reg=Registration()
    dialog_exit=DialogExitWindow()
    autho = Authorithation()
    menu=Menu()
    autho.show()
    sys.exit(app.exec_())

# form.action.clicked.connect()

# form.push_button_reg.clicked.connect(lambda: check(form.line_edit_phone_2.text(),
# form.line_edit_password_2.text(),
# form.line_edit_password_3.text()))
# Добавление qr-code
# pixmap = QPixmap('site.png')
# form.label.setPixmap(pixmap)
