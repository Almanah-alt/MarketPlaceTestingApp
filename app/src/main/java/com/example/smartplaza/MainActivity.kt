package com.example.smartplaza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartplaza.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val walletFragment = WalletFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout_fragment, homeFragment)
            home_icon.setImageResource(R.drawable.ic_outline_home_selected_24)
            addToBackStack(null)
            commit()
        }

        home_icon.setOnClickListener {
            home_icon.setImageResource(R.drawable.ic_outline_home_selected_24)
            wallet_icon.setImageResource(R.drawable.ic_outline_account_balance_wallet_24)
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_fragment, homeFragment)
                addToBackStack(null)
                commit()
            }

        }

        wallet_icon.setOnClickListener {
            home_icon.setImageResource(R.drawable.ic_outline_home_24)
            wallet_icon.setImageResource(R.drawable.ic_outline_account_balance_wallet_selected_24)
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_fragment, walletFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}