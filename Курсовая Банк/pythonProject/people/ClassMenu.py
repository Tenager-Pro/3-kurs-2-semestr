from datetime import date
from Menu import *
from FunctionMenu import *
from ClassHistory import *
class Menu(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_Menu()
        self.ui.setupUi(self)
        self.name = "Name"
        self.id = 0
        self.create_date = date.today()
        self.ui.push_button_exit.clicked.connect(self.exit)
        self.ui.add_accounting_button.clicked.connect(self.add_accouting)
        self.ui.translate_button.clicked.connect(self.translate)
        self.ui.history_button.clicked.connect(self.open_history)
        #self.ui.list_account.currentTextChanged.connect(self.information_about_account) на будущее можно сделать вывод информации о вкладе в визарде

    def open_history(self):
        history = History()
        history.id = self.id
        history.show()
        menu.close()

    def add_item_account_widget(self):
        list_account=get_list_account(self.id)
        for account in list_account:
            str_account = "Название: " + account[0] + "\nНомер счета: " + account[1] +"\nБаланс: " + account[2]
            self.ui.list_account.addItem(str_account)

    def add_item_list_history(self):
        list_history=get_list_history(self.id)
        for operation in list_history:
            date=operation[3].strftime("%B %d, %Y")
            message = "Пополнение: " if (convert_money_in_decimal(operation[2])-convert_money_in_decimal(operation[1]))>0 else "Списание: "
            str_account = "Название: " + operation[0] + "\nБыло: " + operation[1] +"\nСтало: " + operation[2]+"\n"+message+str(convert_money_in_decimal(operation[2])-convert_money_in_decimal(operation[1]))+"\nДата: "+date
            self.ui.list_history.addItem(str_account)

    def translate(self):
        translate_in_your_account.show()
    def add_accouting(self):
        create_account.id = self.id
        create_account.add_account(get_data_account())
        create_account.show()
        menu.hide()

    def exit(self):
        dialog_exit.show()
        menu.setEnabled(False)

    def set_name(self, name):
        self.ui.label_name.setText("Добро пожаловать, " + name + ",")
        self.name = name

    def set_id(self, id):
        self.id = id