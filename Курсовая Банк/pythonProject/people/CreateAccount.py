# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file '..\pythonProject\ui\CreateAccount.ui'
#
# Created by: PyQt5 UI code generator 5.15.7
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_CreateAccount(object):
    def setupUi(self, CreateAccount):
        CreateAccount.setObjectName("CreateAccount")
        CreateAccount.resize(600, 600)
        CreateAccount.setMaximumSize(QtCore.QSize(600, 600))
        CreateAccount.setSizeIncrement(QtCore.QSize(500, 500))
        CreateAccount.setStyleSheet("background: rgb(34,106,170)")
        self.gridLayoutWidget = QtWidgets.QWidget(CreateAccount)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(10, 10, 581, 581))
        self.gridLayoutWidget.setObjectName("gridLayoutWidget")
        self.gridLayout = QtWidgets.QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.gridLayout.setObjectName("gridLayout")
        spacerItem = QtWidgets.QSpacerItem(40, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout.addItem(spacerItem, 7, 0, 1, 1)
        self.horizontalLayout = QtWidgets.QHBoxLayout()
        self.horizontalLayout.setObjectName("horizontalLayout")
        self.create_account_button = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.create_account_button.setFont(font)
        self.create_account_button.setStyleSheet("color: rgb(255,255,255)")
        self.create_account_button.setObjectName("create_account_button")
        self.horizontalLayout.addWidget(self.create_account_button)
        self.chanel_button = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.chanel_button.setFont(font)
        self.chanel_button.setStyleSheet("color: rgb(255,255,255)")
        self.chanel_button.setObjectName("chanel_button")
        self.horizontalLayout.addWidget(self.chanel_button)
        self.gridLayout.addLayout(self.horizontalLayout, 8, 0, 1, 1)
        self.label_7 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_7.setFont(font)
        self.label_7.setStyleSheet("color: rgb(255,255,255)")
        self.label_7.setObjectName("label_7")
        self.gridLayout.addWidget(self.label_7, 2, 0, 1, 1)
        self.label = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label.setFont(font)
        self.label.setStyleSheet("color: rgb(255,255,255)")
        self.label.setObjectName("label")
        self.gridLayout.addWidget(self.label, 0, 0, 1, 1)
        self.name_account = QtWidgets.QComboBox(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.name_account.setFont(font)
        self.name_account.setStyleSheet("color: rgb(255,255,255)")
        self.name_account.setObjectName("name_account")
        self.gridLayout.addWidget(self.name_account, 1, 0, 1, 1)
        self.gridLayout_2 = QtWidgets.QGridLayout()
        self.gridLayout_2.setObjectName("gridLayout_2")
        self.count_month = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.count_month.setFont(font)
        self.count_month.setStyleSheet("color: rgb(255,255,255)")
        self.count_month.setObjectName("count_month")
        self.gridLayout_2.addWidget(self.count_month, 0, 2, 1, 1)
        self.label_6 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_6.setFont(font)
        self.label_6.setStyleSheet("color: rgb(255,255,255)")
        self.label_6.setObjectName("label_6")
        self.gridLayout_2.addWidget(self.label_6, 3, 0, 1, 1)
        self.percentage = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.percentage.setFont(font)
        self.percentage.setStyleSheet("color: rgb(255,255,255)")
        self.percentage.setObjectName("percentage")
        self.gridLayout_2.addWidget(self.percentage, 1, 2, 1, 1)
        self.min_sum = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.min_sum.setFont(font)
        self.min_sum.setStyleSheet("color: rgb(255,255,255)")
        self.min_sum.setObjectName("min_sum")
        self.gridLayout_2.addWidget(self.min_sum, 3, 2, 1, 1)
        self.horizontalLayout_2 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_2.setObjectName("horizontalLayout_2")
        self.is_replenishment = QtWidgets.QCheckBox(self.gridLayoutWidget)
        self.is_replenishment.setEnabled(False)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.is_replenishment.setFont(font)
        self.is_replenishment.setStyleSheet("color: rgb(255,255,255); \n"
"QCheckBox::indicator{background-color: rgb(255,0,0)}")
        self.is_replenishment.setObjectName("is_replenishment")
        self.horizontalLayout_2.addWidget(self.is_replenishment)
        self.is_withdrawal = QtWidgets.QCheckBox(self.gridLayoutWidget)
        self.is_withdrawal.setEnabled(False)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.is_withdrawal.setFont(font)
        self.is_withdrawal.setStyleSheet("color: rgb(255,255,255)")
        self.is_withdrawal.setObjectName("is_withdrawal")
        self.horizontalLayout_2.addWidget(self.is_withdrawal)
        self.gridLayout_2.addLayout(self.horizontalLayout_2, 6, 0, 1, 3)
        self.label_4 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_4.setFont(font)
        self.label_4.setStyleSheet("color: rgb(255,255,255)")
        self.label_4.setObjectName("label_4")
        self.gridLayout_2.addWidget(self.label_4, 1, 0, 1, 1)
        self.income = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.income.setFont(font)
        self.income.setStyleSheet("color: rgb(255,255,255)")
        self.income.setObjectName("income")
        self.gridLayout_2.addWidget(self.income, 4, 2, 1, 1)
        self.label_2 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_2.setFont(font)
        self.label_2.setStyleSheet("color: rgb(255,255,255)")
        self.label_2.setObjectName("label_2")
        self.gridLayout_2.addWidget(self.label_2, 0, 0, 1, 1)
        self.label_8 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_8.setFont(font)
        self.label_8.setStyleSheet("color: rgb(255,255,255)")
        self.label_8.setObjectName("label_8")
        self.gridLayout_2.addWidget(self.label_8, 4, 0, 1, 1)
        self.gridLayout.addLayout(self.gridLayout_2, 4, 0, 1, 1)
        self.check_money_account = QtWidgets.QRadioButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.check_money_account.setFont(font)
        self.check_money_account.setStyleSheet("color: rgb(255,255,255)")
        self.check_money_account.setObjectName("check_money_account")
        self.gridLayout.addWidget(self.check_money_account, 6, 0, 1, 1)
        spacerItem1 = QtWidgets.QSpacerItem(40, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout.addItem(spacerItem1, 5, 0, 1, 1)

        self.retranslateUi(CreateAccount)
        QtCore.QMetaObject.connectSlotsByName(CreateAccount)

    def retranslateUi(self, CreateAccount):
        _translate = QtCore.QCoreApplication.translate
        CreateAccount.setWindowTitle(_translate("CreateAccount", "Create account"))
        self.create_account_button.setText(_translate("CreateAccount", "Создать счет"))
        self.chanel_button.setText(_translate("CreateAccount", "Отмена"))
        self.label_7.setText(_translate("CreateAccount", "Условия:"))
        self.label.setText(_translate("CreateAccount", "Настройки счета:"))
        self.count_month.setText(_translate("CreateAccount", "TextLabel"))
        self.label_6.setText(_translate("CreateAccount", "Сумма:"))
        self.percentage.setText(_translate("CreateAccount", "TextLabel"))
        self.is_replenishment.setText(_translate("CreateAccount", "Пополнение"))
        self.is_withdrawal.setText(_translate("CreateAccount", "Снятие"))
        self.label_4.setText(_translate("CreateAccount", "Прооцент:"))
        self.income.setText(_translate("CreateAccount", "TextLabel"))
        self.label_2.setText(_translate("CreateAccount", "Срок:"))
        self.label_8.setText(_translate("CreateAccount", "Доход:"))
        self.check_money_account.setText(_translate("CreateAccount", "Оставить деньги на счете"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    CreateAccount = QtWidgets.QDialog()
    ui = Ui_CreateAccount()
    ui.setupUi(CreateAccount)
    CreateAccount.show()
    sys.exit(app.exec_())
