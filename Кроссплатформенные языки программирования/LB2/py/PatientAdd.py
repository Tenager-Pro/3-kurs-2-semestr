# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file '..\LB2\ui\patientAdd.ui'
#
# Created by: PyQt5 UI code generator 5.15.4
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_PatientAdd(object):
    def setupUi(self, PatientAdd):
        PatientAdd.setObjectName("PatientAdd")
        PatientAdd.resize(800, 210)
        self.centralwidget = QtWidgets.QWidget(PatientAdd)
        self.centralwidget.setObjectName("centralwidget")
        self.gridLayoutWidget = QtWidgets.QWidget(self.centralwidget)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(9, 9, 781, 191))
        self.gridLayoutWidget.setObjectName("gridLayoutWidget")
        self.gridLayout = QtWidgets.QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.gridLayout.setObjectName("gridLayout")
        self.horizontalLayout = QtWidgets.QHBoxLayout()
        self.horizontalLayout.setObjectName("horizontalLayout")
        self.buttonBack = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.buttonBack.setFont(font)
        self.buttonBack.setObjectName("buttonBack")
        self.horizontalLayout.addWidget(self.buttonBack)
        self.buttonAdd = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.buttonAdd.setFont(font)
        self.buttonAdd.setObjectName("buttonAdd")
        self.horizontalLayout.addWidget(self.buttonAdd)
        self.gridLayout.addLayout(self.horizontalLayout, 3, 0, 1, 2)
        self.name = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.name.setFont(font)
        self.name.setObjectName("name")
        self.gridLayout.addWidget(self.name, 0, 1, 1, 1)
        self.label_2 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_2.setFont(font)
        self.label_2.setObjectName("label_2")
        self.gridLayout.addWidget(self.label_2, 1, 0, 1, 1)
        self.label_3 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_3.setFont(font)
        self.label_3.setObjectName("label_3")
        self.gridLayout.addWidget(self.label_3, 2, 0, 1, 1)
        self.phoneNumber = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.phoneNumber.setFont(font)
        self.phoneNumber.setObjectName("phoneNumber")
        self.gridLayout.addWidget(self.phoneNumber, 1, 1, 1, 1)
        self.label = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label.setFont(font)
        self.label.setObjectName("label")
        self.gridLayout.addWidget(self.label, 0, 0, 1, 1)
        self.birthDate = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.birthDate.setFont(font)
        self.birthDate.setObjectName("birthDate")
        self.gridLayout.addWidget(self.birthDate, 2, 1, 1, 1)
        PatientAdd.setCentralWidget(self.centralwidget)

        self.retranslateUi(PatientAdd)
        QtCore.QMetaObject.connectSlotsByName(PatientAdd)

    def retranslateUi(self, PatientAdd):
        _translate = QtCore.QCoreApplication.translate
        PatientAdd.setWindowTitle(_translate("PatientAdd", "MainWindow"))
        self.buttonBack.setText(_translate("PatientAdd", "??????????"))
        self.buttonAdd.setText(_translate("PatientAdd", "????????????????"))
        self.label_2.setText(_translate("PatientAdd", "??????????????"))
        self.label_3.setText(_translate("PatientAdd", "???????? ????????????????"))
        self.label.setText(_translate("PatientAdd", "??????"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    PatientAdd = QtWidgets.QMainWindow()
    ui = Ui_PatientAdd()
    ui.setupUi(PatientAdd)
    PatientAdd.show()
    sys.exit(app.exec_())
