import random

class Counting:

    def __init__(self, name, user,create_date, end_date, balance, condition, pin):
        self.name=name
        self.user=user
        self.barcode = random.randint(10000000, 99999999)
        self.create_date=create_date
        self.end_date = end_date
        self.balance = balance
        self.condition = condition
        self.pin = pin


