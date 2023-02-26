import sys
from PyQt5 import uic
from PyQt5 import QtWidgets
from PyQt5.QtWidgets import QDialog, QApplication
from PyQt5.uic import loadUi
from re import sub
from decimal import Decimal
from PyQt5.QtWidgets import QMessageBox
from datetime import date
from patient_db import *
from contract_db import *
from doctor_db import *
from patient_card_db import *
from Menu import *

class Menu(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)

if __name__ == "__main__":
    name = ""
    app = QtWidgets.QApplication(sys.argv)
    menu = Menu()
    menu.show()