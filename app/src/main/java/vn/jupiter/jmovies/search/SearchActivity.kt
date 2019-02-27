package vn.jupiter.jmovies.search

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_search.*
import vn.jupiter.jmovies.R
import vn.jupiter.jmovies.databinding.ActivitySearchBinding
import vn.jupiter.jmovies.ui.common.ActivityBindingComponent

class SearchActivity : AppCompatActivity() {
    private lateinit var searchActionView: SearchView
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search, ActivityBindingComponent(this))
        val vm = ViewModelProviders.of(this)[SearchViewModel::class.java]
        binding.query = vm.query
        binding.listData = vm.moviesList

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchMenu = menu?.findItem(R.id.menu_search)
        searchActionView = searchMenu?.actionView!! as SearchView
        setupSearchMenu(searchActionView)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_search) {
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupSearchMenu(searchActionView: SearchView) {
        searchActionView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
}
