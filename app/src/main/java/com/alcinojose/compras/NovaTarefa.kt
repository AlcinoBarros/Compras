package com.alcinojose.compras

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment

class NovaTarefa : DialogFragment() {

    private lateinit var editTextNome: EditText
    private lateinit var editTextDesc: EditText

    private var item: Item? = null

    private val isNovaTarefa: Boolean by lazy {
        arguments?.getBoolean("isNovaTarefa", false) ?: false
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        arguments?.let{
            item = it.getSerializable("item") as? Item
        }

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            val view = inflater.inflate(R.layout.nova_tarefa, null)

            editTextNome = view.findViewById(R.id.novaTarefaTexto)
            editTextDesc = view.findViewById(R.id.novaTarefaDescricao)


            if (item != null) {
                editTextNome.setText(item!!.titulo)
                editTextDesc.setText(item!!.descricao)
            }

            builder.setView(view)
                .setPositiveButton("Adicionar") { dialog, id ->
                    val contatoId = item?.id
                    val nome = editTextNome.text.toString()
                    val descricao = editTextDesc.toString()


                    if (isNovaTarefa) {
                        (activity as? ProprietarioListener)?.onProprietarioAdicionado(contatoId, nome, descricao)
                    } else {
                        (activity as? ContatoListener)?.onContatoAdicionado(contatoId, nome, descricao)
                    }
                }
                .setNegativeButton("Cancelar") { dialog, id ->
                    dialog.cancel()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    interface ContatoListener {
        fun onContatoAdicionado(id: Int?, nome: String, descricao: String)
    }

    interface ProprietarioListener {
        fun onProprietarioAdicionado(id: Int?, nome: String, descricao: String)
    }

}