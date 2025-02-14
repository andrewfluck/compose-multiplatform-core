/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose.integration.macrobenchmark.target

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        val pager = findViewById<ViewPager2>(R.id.pager)
        val itemCount = intent.getIntExtra(ExtraItemCount, 3000)
        val adapter = PagerAdapter(itemCount)
        pager.adapter = adapter
        launchIdlenessTracking()
    }

    companion object {
        const val ExtraItemCount = "ITEM_COUNT"
    }
}

private class PagerAdapter(val items: Int) : RecyclerView.Adapter<PagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_pager_item, parent, false)

        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(position.toString())
    }

    override fun getItemCount(): Int = items
}

private class PagerViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: String) {
        itemView.findViewById<TextView>(R.id.view_pager_item).text = item
    }
}