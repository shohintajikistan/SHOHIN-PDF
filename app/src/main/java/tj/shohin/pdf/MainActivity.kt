
package tj.shohin.pdf

import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val bg = Color.rgb(7, 28, 22)
    private val card = Color.rgb(13, 48, 36)
    private val green = Color.rgb(8, 165, 108)
    private val gold = Color.rgb(186, 240, 91)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
            setPadding(22, 30, 22, 20)
        }

        val scroll = ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val logo = TextView(this).apply {
            text = "👑"
            textSize = 38f
            gravity = Gravity.CENTER
        }
        content.addView(logo)

        val title = TextView(this).apply {
            text = "SHOHIN PDF"
            textSize = 28f
            setTextColor(gold)
            gravity = Gravity.CENTER
            letterSpacing = 0.12f
        }
        content.addView(title)

        val subtitle = TextView(this).apply {
            text = "PDF • PHOTO • SCANNER • OCR"
            textSize = 12f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 8, 0, 25)
        }
        content.addView(subtitle)

        val heading = TextView(this).apply {
            text = "Инструменты"
            textSize = 21f
            setTextColor(Color.WHITE)
            setPadding(0, 10, 0, 15)
        }
        content.addView(heading)

        val tools = listOf(
            "📷  Сканировать книгу (OCR)",
            "📄  Фото в PDF",
            "🗜  Сжать PDF",
            "🔗  Объединить PDF",
            "✂️  Разделить PDF",
            "🖼  PDF в изображения",
            "📝  Извлечь текст",
            "📂  Мои документы"
        )

        tools.forEach { name ->
            val button = Button(this).apply {
                text = name
                textSize = 15f
                isAllCaps = false
                setTextColor(Color.WHITE)
                setBackgroundTintList(
                    android.content.res.ColorStateList.valueOf(card)
                )
                setPadding(16, 18, 16, 18)
                setOnClickListener {
                    Toast.makeText(
                        this@MainActivity,
                        "Функция будет подключена: $name",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.bottomMargin = 10
            content.addView(button, params)
        }

        val footer = TextView(this).apply {
            text = "SHOHIN TAJIKISTAN © 2026"
            textSize = 11f
            setTextColor(green)
            gravity = Gravity.CENTER
            setPadding(0, 25, 0, 10)
        }
        content.addView(footer)

        scroll.addView(content)
        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(root)
    }
}
