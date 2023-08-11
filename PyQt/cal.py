from PySide6.QtWidgets import QApplication, QWidget, QGridLayout, QLineEdit, QPushButton, QLabel, QComboBox, QMessageBox
from PySide6.QtGui import QDoubleValidator, QFont
from PySide6.QtCore import Qt
from qt_material import apply_stylesheet
import sys


class MyLineEdit(QLineEdit):
    def __init__(self, default_text):
        super().__init__(default_text)
        self.default_text = default_text
        self.setAlignment(Qt.AlignmentFlag.AlignRight)

    def focusInEvent(self, event):
        super().focusInEvent(event)
        if self.text() == self.default_text:
            self.clear()


class CalculatorApp(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle('Total Price Estimator')

        layout = QGridLayout()

        font = QFont()
        font.setPointSize(font.pointSize() * 2)

        self.trade_in_value_label = QLabel('Trade-in Value')
        self.trade_in_value_label.setFont(font)
        self.trade_in_value_input = MyLineEdit('0')
        self.trade_in_value_input.setFont(font)
        self.trade_in_value_input.setValidator(QDoubleValidator())
        layout.addWidget(self.trade_in_value_label, 0, 0)
        layout.addWidget(self.trade_in_value_input, 0, 1)

        self.payment_label = QLabel('Payment')
        self.payment_label.setFont(font)
        self.payment_input = MyLineEdit('0')
        self.payment_input.setFont(font)
        self.payment_input.setValidator(QDoubleValidator())
        layout.addWidget(self.payment_label, 1, 0)
        layout.addWidget(self.payment_input, 1, 1)

        self.payment_frequency_label = QLabel('Payment Frequency')
        self.payment_frequency_label.setFont(font)
        self.payment_frequency_input = QComboBox()
        self.payment_frequency_input.setFont(font)
        self.payment_frequency_input.addItem('Bi-weekly', 52)
        self.payment_frequency_input.addItem('Monthly', 12)
        layout.addWidget(self.payment_frequency_label, 2, 0)
        layout.addWidget(self.payment_frequency_input, 2, 1)

        self.term_label = QLabel('Term')
        self.term_label.setFont(font)
        self.term_input = MyLineEdit('0')
        self.term_input.setFont(font)
        self.term_input.setValidator(QDoubleValidator())
        layout.addWidget(self.term_label, 3, 0)
        layout.addWidget(self.term_input, 3, 1)

        self.esti_price_label = QLabel('Esti. Total Price')
        self.esti_price_label.setFont(font)
        self.esti_price_button = QPushButton('Calculate')
        self.esti_price_button.setFont(font)
        self.esti_price_output = QLineEdit()
        self.esti_price_output.setFont(font)
        self.esti_price_output.setReadOnly(True)
        self.esti_price_output.setAlignment(Qt.AlignmentFlag.AlignRight)
        layout.addWidget(self.esti_price_label, 4, 0)
        layout.addWidget(self.esti_price_button, 4, 1)
        layout.addWidget(self.esti_price_output, 5, 0, 1, 2)

        self.esti_price_button.clicked.connect(self.calculate_price)

        self.setLayout(layout)

    def calculate_price(self):
        if not self.trade_in_value_input.text() or not self.payment_input.text() or not self.term_input.text():
            QMessageBox.critical(self, 'Error', 'All fields must be filled')
            return

        try:
            trade_in_value = float(self.trade_in_value_input.text())
            payment = float(self.payment_input.text())
            payment_frequency = self.payment_frequency_input.currentData(Qt.ItemDataRole.UserRole)
            term = float(self.term_input.text())

            total_price = (payment * payment_frequency * term - trade_in_value) * 0.7 / 1.13

            formatted_price = "${:,.2f}".format(total_price)

            self.esti_price_output.setText(formatted_price)
        except ValueError:
            QMessageBox.critical(self, 'Error', 'Invalid input')


if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = CalculatorApp()
    apply_stylesheet(app, theme='light_blue.xml')
    window.show()

    sys.exit(app.exec())
