package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener {
            textViewLoan.setText("Loan :")
            textViewInterest.setText("Interest :")
            textViewMonthlyRepayment.setText("Monthly Repayment :")
            val cp = editTextCarPrice.text.toString()
            val dp = editTextDownPayment.text.toString()
            val lp = editTextLoanPeriod.text.toString()
            val ir = editTextInterestRate.text.toString()
            var carLoan = 0
            var interest = 0.0
            var monthlyRepayment = 0.0
            if(cp.toString().equals("") || dp.toString().equals("") || lp.toString().equals("") || ir.toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Please fill in the detail to calculate.", Toast.LENGTH_SHORT).show()
                println("toasted.")
            }
            else {
                carLoan = cp.toInt() - dp.toInt()
                interest = carLoan * (ir.toDouble()/100) * lp.toInt()
                monthlyRepayment = (carLoan + interest) / lp.toInt() / 12
                textViewLoan.append(carLoan.toString())
                textViewInterest.append(interest.toString())
                textViewMonthlyRepayment.append(String.format("%.2f",monthlyRepayment))
            }
        }
        buttonReset.setOnClickListener {
            editTextCarPrice.setText("")
            editTextDownPayment.setText("")
            editTextInterestRate.setText("")
            editTextLoanPeriod.setText("")
            textViewLoan.setText("Loan :")
            textViewInterest.setText("Interest :")
            textViewMonthlyRepayment.setText("Monthly Repayment :")

        }
    }
}
