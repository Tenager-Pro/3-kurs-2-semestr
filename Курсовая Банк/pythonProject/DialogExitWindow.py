# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file '..\pythonProject\ui\DialogExitWindow.ui'
#
# Created by: PyQt5 UI code generator 5.15.7
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_DialogExitWindow(object):
    def setupUi(self, DialogExitWindow):
        DialogExitWindow.setObjectName("DialogExitWindow")
        DialogExitWindow.setWindowModality(QtCore.Qt.ApplicationModal)
        DialogExitWindow.resize(400, 240)
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("..\\pythonProject\\ui\\Картинки/bank_78392.ico"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        DialogExitWindow.setWindowIcon(icon)
        DialogExitWindow.setStyleSheet("background: rgb(34,106,170)")
        self.gridLayoutWidget = QtWidgets.QWidget(DialogExitWindow)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(10, 10, 381, 221))
        self.gridLayoutWidget.setObjectName("gridLayoutWidget")
        self.gridLayout = QtWidgets.QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.gridLayout.setObjectName("gridLayout")
        self.label = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.label.setFont(font)
        self.label.setStyleSheet("color: rgb(255,255,255)")
        self.label.setTextFormat(QtCore.Qt.AutoText)
        self.label.setObjectName("label")
        self.gridLayout.addWidget(self.label, 0, 0, 1, 1)
        self.horizontalLayout = QtWidgets.QHBoxLayout()
        self.horizontalLayout.setObjectName("horizontalLayout")
        self.push_button_ok = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.push_button_ok.setFont(font)
        self.push_button_ok.setStyleSheet("color: rgb(255,255,255)")
        self.push_button_ok.setObjectName("push_button_ok")
        self.horizontalLayout.addWidget(self.push_button_ok)
        self.push_button_cancel = QtWidgets.QPushButton(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.push_button_cancel.setFont(font)
        self.push_button_cancel.setStyleSheet("color: rgb(255,255,255)")
        self.push_button_cancel.setObjectName("push_button_cancel")
        self.horizontalLayout.addWidget(self.push_button_cancel)
        self.gridLayout.addLayout(self.horizontalLayout, 1, 0, 1, 1)

        self.retranslateUi(DialogExitWindow)
        QtCore.QMetaObject.connectSlotsByName(DialogExitWindow)

    def retranslateUi(self, DialogExitWindow):
        _translate = QtCore.QCoreApplication.translate
        DialogExitWindow.setWindowTitle(_translate("DialogExitWindow", "Exit"))
        self.label.setText(_translate("DialogExitWindow", "Вы точно хотите выйти?"))
        self.push_button_ok.setText(_translate("DialogExitWindow", "OK"))
        self.push_button_cancel.setText(_translate("DialogExitWindow", "Отмена"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    DialogExitWindow = QtWidgets.QDialog()
    ui = Ui_DialogExitWindow()
    ui.setupUi(DialogExitWindow)
    DialogExitWindow.show()
    sys.exit(app.exec_())
