import random

class Account:
    def __init__(self, user_id,create_date, balance, condition_id):
        self.user_id = user_id
        self.create_date = create_date
        self.balance = balance
        self.condition_id = condition_id
        self.account_number = str(random.randint(10000000, 99999999))+str(user_id)


    def get_user_id(self):
        return self.user_id

    def get_balance(self):
        return self.balance

    def get_create_date(self):
        return self.create_date

    def get_condition_id(self):
        return self.condition_id

    def get_account_number(self):
        return self.account_number


