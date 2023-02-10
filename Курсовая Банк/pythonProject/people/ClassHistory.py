from History import *
from FunctionHistory import *
from Converting import *


class History(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_History()
        self.ui.setupUi(self)
        self.id = 0


    def add_data_in_list_history(self):
        list_history = get_list_history(self.id,)
        for operation in list_history:
            date = operation[3].strftime("%B %d, %Y")
            message = "Пополнение: " if (convert_money_in_decimal(operation[2]) - convert_money_in_decimal(
                operation[1])) > 0 else "Списание: "
            str_account = "Название: " + operation[0] + "\nБыло: " + operation[1] + "\nСтало: " + operation[
                2] + "\n" + message + str(
                convert_money_in_decimal(operation[2]) - convert_money_in_decimal(operation[1])) + "\nДата: " + date
            self.ui.list_history.addItem(str_account)