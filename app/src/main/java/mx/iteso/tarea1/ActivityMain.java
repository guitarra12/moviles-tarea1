package mx.iteso.tarea1;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {
    private EditText etNombre;
    private EditText etTelefono;
    private RadioGroup rgGenero;
    private CheckBox chckbxIsDeportivo;
    private Spinner spEscolaridad;
    private AutoCompleteTextView actvLibroFav;

    private Alumno alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.am_et_nombre);
        etTelefono = findViewById(R.id.am_et_telefono);
        rgGenero = findViewById(R.id.am_rg_genero);
        chckbxIsDeportivo = findViewById(R.id.am_cb_practicaDeporte);

        ((RadioButton)findViewById(R.id.am_rb_genero_fem)).setChecked(true);

        spEscolaridad = findViewById(R.id.am_sp_escolaridad);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.am_sp_escolaridad_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEscolaridad.setAdapter(adapter);

        actvLibroFav = findViewById(R.id.am_actv_librofav);
        String []actvLibros = getResources().getStringArray(R.array.am_actv_libros_options);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, actvLibros);
        actvLibroFav.setAdapter(adapter1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_main_save:
                onBtnGuardarClick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBtnGuardarClick() {
        String val="";
        if(rgGenero.getCheckedRadioButtonId()!=-1){
            int id= rgGenero.getCheckedRadioButtonId();
            View radioButton = rgGenero.findViewById(id);
            int radioId = rgGenero.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) rgGenero.getChildAt(radioId);
            val = (String) btn.getText();
        }

        alumno = new Alumno(etNombre.getText().toString(), etTelefono.getText().toString()
        ,spEscolaridad.getSelectedItem().toString(), val, actvLibroFav.getText().toString()
                , chckbxIsDeportivo.isChecked());

        Toast toast = Toast.makeText(this, alumno.toString(), Toast.LENGTH_LONG);
        toast.show();
        limpiar();
    }

    public void onBtnLimpiarClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
        builder.setMessage(R.string.am_dialog_clean_message)
                .setPositiveButton(R.string.am_si, (dialog, which)->{
                    alumno = null;
                    limpiar();
                }).setNegativeButton(R.string.am_no, (dialog, which)->{

        });
        builder.show();
    }

    public void limpiar() {
        etNombre.setText("");
        etTelefono.setText("");
        spEscolaridad.setSelection(0);
        rgGenero.check(R.id.am_rb_genero_fem);
        actvLibroFav.setText("");
        chckbxIsDeportivo.setChecked(false);
    }
}
