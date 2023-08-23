package com.example.a5_veiwbinding

//class ImageAdapter : BaseAdapter() {
//    override fun getCount(): Int {
//        return mThumbIds.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return mThumbIds[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val imageView: ImageView
//        if(convertView == null) {
//            imageView = ImageView(parent!!.context)
//            imageView.layoutParams = AbsListView.LayoutParams(200, 200)
//            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
//            imageView.setPadding(8,8,8,8)
//        }
//        else {
//            imageView = convertView as ImageView
//        }
//
//        imageView.setImageResource(mThumbIds[position])
//        return imageView
//    }
//
//
//    private val mThumbIds = arrayOf<Int>(
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//        android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//
//        )
//}