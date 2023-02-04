# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file '..\pythonProject\ui\CreateNewAccount.ui'
#
# Created by: PyQt5 UI code generator 5.15.7
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_CreateAccount(object):
    def setupUi(self, CreateAccount):
        CreateAccount.setObjectName("CreateAccount")
        CreateAccount.resize(600, 500)
        CreateAccount.setMaximumSize(QtCore.QSize(600, 500))
        CreateAccount.setSizeIncrement(QtCore.QSize(500, 500))
        CreateAccount.setStyleSheet("")
        self.gridLayoutWidget = QtWidgets.QWidget(CreateAccount)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(10, 10, 581, 481))
        self.gridLayoutWidget.setObjectName("gridLayoutWidget")
        self.gridLayout = QtWidgets.QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.gridLayout.setObjectName("gridLayout")
        self.label = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label.setFont(font)
        self.label.setStyleSheet("")
        self.label.setObjectName("label")
        self.gridLayout.addWidget(self.label, 0, 0, 1, 1)
        self.label_7 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_7.setFont(font)
        self.label_7.setStyleSheet("")
        self.label_7.setObjectName("label_7")
        self.gridLayout.addWidget(self.label_7, 4, 0, 1, 1)
        spacerItem = QtWidgets.QSpacerItem(40, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout.addItem(spacerItem, 7, 0, 1, 1)
        self.horizontalLayout_5 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_5.setObjectName("horizontalLayout_5")
        self.label_10 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_10.setFont(font)
        self.label_10.setStyleSheet("")
        self.label_10.setObjectName("label_10")
        self.horizontalLayout_5.addWidget(self.label_10)
        self.name_accounting = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.name_accounting.setFont(font)
        self.name_accounting.setStyleSheet("")
        self.name_accounting.setObjectName("name_accounting")
        self.horizontalLayout_5.addWidget(self.name_accounting)
        self.gridLayout.addLayout(self.horizontalLayout_5, 2, 0, 1, 1)
        self.horizontalLayout = QtWidgets.QHBoxLayout()
        self.horizontalLayout.setObjectName("horizontalLayout")
        self.create_account_button = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.create_account_button.setFont(font)
        self.create_account_button.setStyleSheet("")
        self.create_account_button.setObjectName("create_account_button")
        self.horizontalLayout.addWidget(self.create_account_button)
        self.chanel_button = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.chanel_button.setFont(font)
        self.chanel_button.setStyleSheet("")
        self.chanel_button.setObjectName("chanel_button")
        self.horizontalLayout.addWidget(self.chanel_button)
        self.gridLayout.addLayout(self.horizontalLayout, 8, 0, 1, 1)
        self.gridLayout_2 = QtWidgets.QGridLayout()
        self.gridLayout_2.setObjectName("gridLayout_2")
        self.label_2 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_2.setFont(font)
        self.label_2.setStyleSheet(")")
        self.label_2.setObjectName("label_2")
        self.gridLayout_2.addWidget(self.label_2, 0, 0, 1, 1)
        self.horizontalLayout_2 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_2.setObjectName("horizontalLayout_2")
        self.is_replenishment = QtWidgets.QCheckBox(self.gridLayoutWidget)
        self.is_replenishment.setEnabled(True)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.is_replenishment.setFont(font)
        self.is_replenishment.setStyleSheet("")
        self.is_replenishment.setObjectName("is_replenishment")
        self.horizontalLayout_2.addWidget(self.is_replenishment)
        self.is_withdrawal = QtWidgets.QCheckBox(self.gridLayoutWidget)
        self.is_withdrawal.setEnabled(True)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.is_withdrawal.setFont(font)
        self.is_withdrawal.setStyleSheet("")
        self.is_withdrawal.setObjectName("is_withdrawal")
        self.horizontalLayout_2.addWidget(self.is_withdrawal)
        self.gridLayout_2.addLayout(self.horizontalLayout_2, 5, 0, 1, 3)
        self.label_4 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_4.setFont(font)
        self.label_4.setStyleSheet("")
        self.label_4.setObjectName("label_4")
        self.gridLayout_2.addWidget(self.label_4, 1, 0, 1, 1)
        self.count_month = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.count_month.setFont(font)
        self.count_month.setStyleSheet("")
        self.count_month.setObjectName("count_month")
        self.gridLayout_2.addWidget(self.count_month, 0, 1, 1, 2)
        self.percentage = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.percentage.setFont(font)
        self.percentage.setStyleSheet("")
        self.percentage.setObjectName("percentage")
        self.gridLayout_2.addWidget(self.percentage, 1, 1, 1, 2)
        self.min_sum = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.min_sum.setFont(font)
        self.min_sum.setStyleSheet("")
        self.min_sum.setObjectName("min_sum")
        self.gridLayout_2.addWidget(self.min_sum, 3, 1, 1, 2)
        self.label_6 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_6.setFont(font)
        self.label_6.setStyleSheet("")
        self.label_6.setObjectName("label_6")
        self.gridLayout_2.addWidget(self.label_6, 3, 0, 1, 1)
        self.gridLayout.addLayout(self.gridLayout_2, 6, 0, 1, 1)

        self.retranslateUi(CreateAccount)
        QtCore.QMetaObject.connectSlotsByName(CreateAccount)

    def retranslateUi(self, CreateAccount):
        _translate = QtCore.QCoreApplication.translate
        CreateAccount.setWindowTitle(_translate("CreateAccount", "Create account"))
        self.label.setText(_translate("CreateAccount", "Настройки счета:"))
        self.label_7.setText(_translate("CreateAccount", "Условия:"))
        self.label_10.setText(_translate("CreateAccount", "Название:"))
        self.create_account_button.setText(_translate("CreateAccount", "Создать счет"))
        self.chanel_button.setText(_translate("CreateAccount", "Отмена"))
        self.label_2.setText(_translate("CreateAccount", "Срок:"))
        self.is_replenishment.setText(_translate("CreateAccount", "Пополнение"))
        self.is_withdrawal.setText(_translate("CreateAccount", "Снятие"))
        self.label_4.setText(_translate("CreateAccount", "Прооцент:"))
        self.label_6.setText(_translate("CreateAccount", "Мин. сумма:"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    CreateAccount = QtWidgets.QDialog()
    ui = Ui_CreateAccount()
    ui.setupUi(CreateAccount)
    CreateAccount.show()
    sys.exit(app.exec_())
