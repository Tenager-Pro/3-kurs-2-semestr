# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file '..\pythonProject\ui\TranslateInAccount.ui'
#
# Created by: PyQt5 UI code generator 5.15.7
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_TranslateInAccount(object):
    def setupUi(self, TranslateInAccount):
        TranslateInAccount.setObjectName("TranslateInAccount")
        TranslateInAccount.resize(420, 420)
        TranslateInAccount.setMinimumSize(QtCore.QSize(420, 420))
        TranslateInAccount.setMaximumSize(QtCore.QSize(420, 420))
        TranslateInAccount.setStyleSheet("background: rgb(34,106,170)")
        self.gridLayoutWidget = QtWidgets.QWidget(TranslateInAccount)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(10, 10, 398, 404))
        self.gridLayoutWidget.setObjectName("gridLayoutWidget")
        self.gridLayout = QtWidgets.QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.gridLayout.setObjectName("gridLayout")
        spacerItem = QtWidgets.QSpacerItem(40, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout.addItem(spacerItem, 12, 0, 1, 1)
        self.translate_button = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.translate_button.setFont(font)
        self.translate_button.setStyleSheet("color: rgb(255,255,255)")
        self.translate_button.setObjectName("translate_button")
        self.gridLayout.addWidget(self.translate_button, 13, 0, 1, 2)
        spacerItem1 = QtWidgets.QSpacerItem(40, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout.addItem(spacerItem1, 2, 0, 1, 1)
        self.label_3 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_3.setFont(font)
        self.label_3.setStyleSheet("color: rgb(255,255,255)")
        self.label_3.setObjectName("label_3")
        self.gridLayout.addWidget(self.label_3, 8, 0, 1, 1)
        self.comboBox = QtWidgets.QComboBox(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.comboBox.setFont(font)
        self.comboBox.setStyleSheet("color: rgb(255,255,255)")
        self.comboBox.setObjectName("comboBox")
        self.gridLayout.addWidget(self.comboBox, 3, 1, 1, 2)
        self.horizontalLayout = QtWidgets.QHBoxLayout()
        self.horizontalLayout.setObjectName("horizontalLayout")
        self.translate_in_your_account = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.translate_in_your_account.setFont(font)
        self.translate_in_your_account.setStyleSheet("color: rgb(255,255,255)")
        self.translate_in_your_account.setObjectName("translate_in_your_account")
        self.horizontalLayout.addWidget(self.translate_in_your_account)
        self.translate_in_account = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.translate_in_account.setFont(font)
        self.translate_in_account.setStyleSheet("color: rgb(255,255,255);background: rgb(84,126,170)")
        self.translate_in_account.setObjectName("translate_in_account")
        self.horizontalLayout.addWidget(self.translate_in_account)
        self.gridLayout.addLayout(self.horizontalLayout, 0, 0, 1, 3)
        spacerItem2 = QtWidgets.QSpacerItem(40, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout.addItem(spacerItem2, 10, 0, 1, 1)
        self.label = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label.setFont(font)
        self.label.setStyleSheet("color: rgb(255,255,255)")
        self.label.setObjectName("label")
        self.gridLayout.addWidget(self.label, 11, 0, 1, 1)
        spacerItem3 = QtWidgets.QSpacerItem(40, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout.addItem(spacerItem3, 6, 0, 1, 1)
        self.label_4 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label_4.setFont(font)
        self.label_4.setStyleSheet("color: rgb(255,255,255)")
        self.label_4.setObjectName("label_4")
        self.gridLayout.addWidget(self.label_4, 3, 0, 1, 1)
        self.lineEdit = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.lineEdit.setFont(font)
        self.lineEdit.setStyleSheet("color: rgb(255,255,255)")
        self.lineEdit.setObjectName("lineEdit")
        self.gridLayout.addWidget(self.lineEdit, 11, 1, 1, 1)
        self.lineEdit_2 = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.lineEdit_2.setFont(font)
        self.lineEdit_2.setStyleSheet("color: rgb(255,255,255)")
        self.lineEdit_2.setObjectName("lineEdit_2")
        self.gridLayout.addWidget(self.lineEdit_2, 8, 1, 1, 1)

        self.retranslateUi(TranslateInAccount)
        QtCore.QMetaObject.connectSlotsByName(TranslateInAccount)

    def retranslateUi(self, TranslateInAccount):
        _translate = QtCore.QCoreApplication.translate
        TranslateInAccount.setWindowTitle(_translate("TranslateInAccount", "??????????????"))
        self.translate_button.setText(_translate("TranslateInAccount", "??????????????????"))
        self.label_3.setText(_translate("TranslateInAccount", "????????:"))
        self.translate_in_your_account.setText(_translate("TranslateInAccount", "?????????? ????????????"))
        self.translate_in_account.setText(_translate("TranslateInAccount", "???????????? ????????"))
        self.label.setText(_translate("TranslateInAccount", "??????????: "))
        self.label_4.setText(_translate("TranslateInAccount", "????????????:"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    TranslateInAccount = QtWidgets.QDialog()
    ui = Ui_TranslateInAccount()
    ui.setupUi(TranslateInAccount)
    TranslateInAccount.show()
    sys.exit(app.exec_())
