# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file '..\LB2\ui\doctorAdd.ui'
#
# Created by: PyQt5 UI code generator 5.15.4
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_DoctorAdd(object):
    def setupUi(self, DoctorAdd):
        DoctorAdd.setObjectName("DoctorAdd")
        DoctorAdd.resize(800, 250)
        self.centralwidget = QtWidgets.QWidget(DoctorAdd)
        self.centralwidget.setObjectName("centralwidget")
        self.gridLayoutWidget = QtWidgets.QWidget(self.centralwidget)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(9, 9, 781, 221))
        self.gridLayoutWidget.setObjectName("gridLayoutWidget")
        self.gridLayout = QtWidgets.QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.gridLayout.setObjectName("gridLayout")
        self.post = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.post.setFont(font)
        self.post.setObjectName("post")
        self.gridLayout.addWidget(self.post, 3, 1, 1, 1)
        self.name = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.name.setFont(font)
        self.name.setObjectName("name")
        self.gridLayout.addWidget(self.name, 0, 1, 1, 1)
        self.phoneNumber = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.phoneNumber.setFont(font)
        self.phoneNumber.setObjectName("phoneNumber")
        self.gridLayout.addWidget(self.phoneNumber, 2, 1, 1, 1)
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
        self.gridLayout.addLayout(self.horizontalLayout, 4, 0, 1, 2)
        self.label_2 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_2.setFont(font)
        self.label_2.setObjectName("label_2")
        self.gridLayout.addWidget(self.label_2, 2, 0, 1, 1)
        self.label = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label.setFont(font)
        self.label.setObjectName("label")
        self.gridLayout.addWidget(self.label, 0, 0, 1, 1)
        self.label_3 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_3.setFont(font)
        self.label_3.setObjectName("label_3")
        self.gridLayout.addWidget(self.label_3, 3, 0, 1, 1)
        self.ratio = QtWidgets.QLineEdit(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.ratio.setFont(font)
        self.ratio.setObjectName("ratio")
        self.gridLayout.addWidget(self.ratio, 1, 1, 1, 1)
        self.label_4 = QtWidgets.QLabel(self.gridLayoutWidget)
        font = QtGui.QFont()
        font.setPointSize(14)
        self.label_4.setFont(font)
        self.label_4.setObjectName("label_4")
        self.gridLayout.addWidget(self.label_4, 1, 0, 1, 1)
        DoctorAdd.setCentralWidget(self.centralwidget)

        self.retranslateUi(DoctorAdd)
        QtCore.QMetaObject.connectSlotsByName(DoctorAdd)

    def retranslateUi(self, DoctorAdd):
        _translate = QtCore.QCoreApplication.translate
        DoctorAdd.setWindowTitle(_translate("DoctorAdd", "MainWindow"))
        self.buttonBack.setText(_translate("DoctorAdd", "??????????"))
        self.buttonAdd.setText(_translate("DoctorAdd", "????????????????"))
        self.label_2.setText(_translate("DoctorAdd", "??????????????"))
        self.label.setText(_translate("DoctorAdd", "??????"))
        self.label_3.setText(_translate("DoctorAdd", "????????"))
        self.label_4.setText(_translate("DoctorAdd", "????????????????????"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    DoctorAdd = QtWidgets.QMainWindow()
    ui = Ui_DoctorAdd()
    ui.setupUi(DoctorAdd)
    DoctorAdd.show()
    sys.exit(app.exec_())
