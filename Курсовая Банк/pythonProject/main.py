from PyQt5 import uic
from PyQt5.QtWidgets import QApplication
from Registration import check
from PyQt5.QtGui import QIcon, QPixmap

Form, Window = uic.loadUiType("ui\\user.ui")
app = QApplication([])
window = Window()
form = Form()
form.setupUi(window)
window.show()
#form.action.clicked.connect()
form.push_button_reg.clicked.connect(lambda: check(form.line_edit_phone_2.text(),
                                           form.line_edit_password_2.text(),
                                           form.line_edit_password_3.text()))
# Добавление qr-code
# pixmap = QPixmap('site.png')
# form.label.setPixmap(pixmap)
app.exec_()
