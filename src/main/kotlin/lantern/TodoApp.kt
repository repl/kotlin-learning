package lantern

import com.googlecode.lanterna.gui2.*
import com.googlecode.lanterna.gui2.table.Table
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory

class TodoApp {
    val table: Table<String> = Table<String>("Name", "Author")

    fun show() {
        val defaultTerminalFactory = DefaultTerminalFactory()
        var screen: Screen? = null
        try {
            screen = defaultTerminalFactory.createScreen()
            screen.startScreen()
            val textGUI = MultiWindowTextGUI(screen)
            val window: Window = BasicWindow("Todos")
            window.setHints(listOf(Window.Hint.CENTERED))
            val contentPanel = Panel(GridLayout(2))
            val gridLayout = contentPanel.layoutManager as GridLayout
            gridLayout.setHorizontalSpacing(3)

            contentPanel.addComponent(Label("Search:"))
            val searchBox = TextBox()
            searchBox.setLayoutData(
                GridLayout.createLayoutData(GridLayout.Alignment.BEGINNING, GridLayout.Alignment.CENTER)
            )
            searchBox.setTextChangeListener { newText: String?, changedByUserInteraction: Boolean ->
                submitNewSearch(
                    newText
                )
            }
            contentPanel.addComponent(searchBox)
            table.setLayoutData(
                GridLayout.createLayoutData(
                    GridLayout.Alignment.BEGINNING,  // Horizontal alignment in the grid cell if the cell is larger than the component's preferred size
                    GridLayout.Alignment.BEGINNING,  // Vertical alignment in the grid cell if the cell is larger than the component's preferred size
                    true,  // Give the component extra horizontal space if available
                    false,  // Give the component extra vertical space if available
                    3,  // Horizontal span
                    1
                )
            ) // Vertical span
            contentPanel.addComponent(table)
            contentPanel.addComponent(
                EmptySpace()
                    .setLayoutData(
                        GridLayout.createHorizontallyFilledLayoutData(2)
                    )
            )
            contentPanel.addComponent(
                Separator(Direction.HORIZONTAL)
                    .setLayoutData(
                        GridLayout.createHorizontallyFilledLayoutData(2)
                    )
            )
            contentPanel.addComponent(
                Button("Close") { window.close() }.setLayoutData(
                    GridLayout.createHorizontallyEndAlignedLayoutData(2)
                )
            )
            window.component = contentPanel
            textGUI.addWindowAndWait(window)
        } finally {
            screen?.let {
                screen.stopScreen()
            }
        }
    }

    private fun submitNewSearch(newText: String?) {
        newText?.let {
            table.tableModel.clear()
            table.tableModel.addRow("Sherlock Holmes", "Arthur")
        }
    }
}

fun main() {
    val lib = Library()
    lib.show()
}