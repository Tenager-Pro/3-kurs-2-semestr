from re import sub
from decimal import Decimal
def convert_money_in_decimal(money):
    income = money
    value = Decimal(sub(r'[^\d.]', '', income))
    return value
