import qrcode


class CreateBarcode:
    def __init__(self, barcode):
        self.barcode = barcode


    def get_number_counting(self):
        return self.barcode

    # Метод построение barcode.
    def get_barcode(self):
        data = self.barcode
        filename = "barcode.png"
        img = qrcode.make(data)
        img.save(filename)
        return 0
