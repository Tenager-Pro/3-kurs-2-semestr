# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file '..\LB2\ui\patientCardAdd.ui'
#
# Created by: PyQt5 UI code generator 5.15.4
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_PatientCardAdd(object):
    def setupUi(self, PatientCardAdd):
        PatientCardAdd.setObjectName("PatientCardAdd")
        PatientCardAdd.resize(800, 400)
        self.centralwidget = QtWidgets.QWidget(PatientCardAdd)
        self.centralwidget.setObjectName("centralwidget")
        self.gridLayoutWidget = QtWidgets.QWidget(self.centralwidget)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(9, 9, 781, 381))
        self.gridLayoutWidget.setObjectName("gridLayoutWidget")
        self.gridLayout = QtWidgets.QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.gridLayout.setObjectName("gridLayout")
        self.label_5 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_5.setFont(font)
        self.label_5.setObjectName("label_5")
        self.gridLayout.addWidget(self.label_5, 4, 0, 1, 1)
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
        self.gridLayout.addLayout(self.horizontalLayout, 7, 0, 1, 2)
        self.label_4 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_4.setFont(font)
        self.label_4.setObjectName("label_4")
        self.gridLayout.addWidget(self.label_4, 3, 0, 1, 1)
        self.price = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.price.setFont(font)
        self.price.setObjectName("price")
        self.gridLayout.addWidget(self.price, 3, 1, 1, 1)
        self.numberCard = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.numberCard.setFont(font)
        self.numberCard.setObjectName("numberCard")
        self.gridLayout.addWidget(self.numberCard, 0, 1, 1, 1)
        self.label_2 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_2.setFont(font)
        self.label_2.setObjectName("label_2")
        self.gridLayout.addWidget(self.label_2, 1, 0, 1, 1)
        self.label_6 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_6.setFont(font)
        self.label_6.setObjectName("label_6")
        self.gridLayout.addWidget(self.label_6, 5, 0, 1, 1)
        self.label_3 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_3.setFont(font)
        self.label_3.setObjectName("label_3")
        self.gridLayout.addWidget(self.label_3, 2, 0, 1, 1)
        self.nameProc = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.nameProc.setFont(font)
        self.nameProc.setObjectName("nameProc")
        self.gridLayout.addWidget(self.nameProc, 1, 1, 1, 1)
        self.label = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label.setFont(font)
        self.label.setObjectName("label")
        self.gridLayout.addWidget(self.label, 0, 0, 1, 1)
        self.createDate = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.createDate.setFont(font)
        self.createDate.setObjectName("createDate")
        self.gridLayout.addWidget(self.createDate, 2, 1, 1, 1)
        self.label_7 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_7.setFont(font)
        self.label_7.setObjectName("label_7")
        self.gridLayout.addWidget(self.label_7, 6, 0, 1, 1)
        self.totalPrice = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.totalPrice.setFont(font)
        self.totalPrice.setReadOnly(True)
        self.totalPrice.setObjectName("totalPrice")
        self.gridLayout.addWidget(self.totalPrice, 6, 1, 1, 1)
        self.comboContract = QtWidgets.QComboBox(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.comboContract.setFont(font)
        self.comboContract.setObjectName("comboContract")
        self.gridLayout.addWidget(self.comboContract, 5, 1, 1, 1)
        self.comboDoctor = QtWidgets.QComboBox(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.comboDoctor.setFont(font)
        self.comboDoctor.setObjectName("comboDoctor")
        self.gridLayout.addWidget(self.comboDoctor, 4, 1, 1, 1)
        PatientCardAdd.setCentralWidget(self.centralwidget)

        self.retranslateUi(PatientCardAdd)
        QtCore.QMetaObject.connectSlotsByName(PatientCardAdd)

    def retranslateUi(self, PatientCardAdd):
        _translate = QtCore.QCoreApplication.translate
        PatientCardAdd.setWindowTitle(_translate("PatientCardAdd", "MainWindow"))
        self.label_5.setText(_translate("PatientCardAdd", "Доктор"))
        self.buttonBack.setText(_translate("PatientCardAdd", "Назад"))
        self.buttonAdd.setText(_translate("PatientCardAdd", "Добавить"))
        self.label_4.setText(_translate("PatientCardAdd", "Цена"))
        self.label_2.setText(_translate("PatientCardAdd", "Наименование процедуры"))
        self.label_6.setText(_translate("PatientCardAdd", "Контракт"))
        self.label_3.setText(_translate("PatientCardAdd", "Дата"))
        self.label.setText(_translate("PatientCardAdd", "Номер карты"))
        self.label_7.setText(_translate("PatientCardAdd", "Конечная цена"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    PatientCardAdd = QtWidgets.QMainWindow()
    ui = Ui_PatientCardAdd()
    ui.setupUi(PatientCardAdd)
    PatientCardAdd.show()
    sys.exit(app.exec_())
