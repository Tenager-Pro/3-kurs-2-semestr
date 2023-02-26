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

if __name__ == "__main__":
    get_data_patient()
    get_data_contract()
    get_data_doctor()
    get_data_patient_card()