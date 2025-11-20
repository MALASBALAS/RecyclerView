package es.etg.pmdm.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(
    private val mList: List<ItemViewModel>
) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null

    // ViewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tarjeta_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        holder.imageView.setImageResource(item.image)
        holder.textView.text = item.descripcion

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, item)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Interfaz para el click listener
    interface OnClickListener {
        fun onClick(position: Int, model: ItemViewModel)
    }

    // Setter del listener
    fun setOnClickListener(listener: OnClickListener?) {
        onClickListener = listener
    }
}
