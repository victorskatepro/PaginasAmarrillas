package com.victorsaico.paginasamarrillas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.victorsaico.paginasamarrillas.DetailActivity;
import com.victorsaico.paginasamarrillas.MainActivity;
import com.victorsaico.paginasamarrillas.R;
import com.victorsaico.paginasamarrillas.adapter.EmpresaAdapter;
import com.victorsaico.paginasamarrillas.model.Empresa;
import com.victorsaico.paginasamarrillas.repository.EmpresaRepository;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class BuscarFragment extends Fragment {
    EmpresaAdapter adapter;
    SearchView buscador;
    ListView lista;
    ArrayList<Empresa> listaEmpresa;
    private String rubro, nombre, direccion,  telefono, correo, url, info;
    private Integer logo, id;
    private ImageView igminfo;
    private static final String TAG = MainActivity.class.getSimpleName();

    private BuscarFragment mainActivity;
    public BuscarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscar, container, false);
        lista = (ListView) view.findViewById(R.id.ContenlistView);
        buscador = (SearchView) view.findViewById(R.id.buscador);
        igminfo = (ImageView) view.findViewById(R.id.imginfo);
         igminfo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 new SweetAlertDialog(getActivity(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                         .setTitleText("Paginas Amarillas")
                         .setContentText("victor.saico@tecsup.edu.pe")
                         .setCustomImage(R.drawable.logopp)
                         .show();
             }
         });
        listaEmpresa = new ArrayList<>();

        Empresa emp1 = new Empresa("KFC","Restaurante",R.drawable.lg_kfc,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,1);

        Empresa emp2 = new Empresa("Scotiabank","Banco",R.drawable.lg_scotiabank,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","311 6000 ", "scotiabank123@hotmail.com",
                "https://www.scotiabank.com.pe/Personas/Default",getResources().getString(R.string.detalle_scotiabank) ,2);

        Empresa emp3 = new Empresa("Móvil Bus","Transporte",R.drawable.lg_movilbus,
                "Paseo de la República N° 749, La Victoría","(01) 716 8000 ", "info@moviltours.com.pe",
                "http://www.moviltours.com.pe/servicios/ejecutivo-vip-movil-Bus/",getResources().getString(R.string.detalle_movilbus) ,3);

        Empresa emp4 = new Empresa("El Comercio","Noticias",R.drawable.lg_comercio,
                "Jr. Santa Rosa #300","505-0505 ", "elcomercio123@hotmail.com",
                "http://elcomercio.pe/",getResources().getString(R.string.detalle_comercio) ,4);

        Empresa emp5 = new Empresa("Entel","Telefonia",R.drawable.lg_entel,
                "Av. Paseo de la República 3490","505-0505 ", "entel123@hotmail.com",
                "http://www.entel.pe/",getResources().getString(R.string.detalle_entel) ,5);

        Empresa emp6 = new Empresa("Latam","Transporte/ Aerolineas",R.drawable.lg_latam,
                "Centro Comercial Jockey Plaza, Av. Javier Prado Este 4200, Tienda 202, 2do piso, Cercado de Lima","505-0505 ", "latam123@hotmail.com",
                "https://www.latam.com/es_pe/",getResources().getString(R.string.detalle_latam) ,6);

        Empresa emp7 = new Empresa("Texas Steakhouse","Restaurante",R.drawable.lg_texas,
                "Av. Defensores del Morro 1803, Chorrillos","5186719", "texasSteakhouse123@hotmail.com",
                "http://www.texasshperu.com/",getResources().getString(R.string.detalle_texas) ,7);

        Empresa emp8 = new Empresa("Tg Láser Oftálmica","Oftalmica",R.drawable.lg_oftalmica,
                "Avenida 2 de Mayo, 666 San Isidro","(01) 4106569", "mtito@tglaseroftalmica.com",
                "http://www.tglaseroftalmica.com",getResources().getString(R.string.detalle_oftal) ,8);

        Empresa emp9 = new Empresa("Luz del sur","Transporte",R.drawable.lg_luzdelsur,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","617-5000", "luzdelsur123@hotmail.com",
                "https://www.luzdelsur.com.pe/",getResources().getString(R.string.detalle_luz) ,9);

        Empresa emp10 = new Empresa("G4S","Seguridad",R.drawable.lg_g4s,
                "Los Ebanistas 146, Cercado de Lima 15023","+51(1)213-1200 ", "comercial.peru@pe.g4s.com",
                "http://www.g4s.com.pe/",getResources().getString(R.string.detalle_g4s) ,10);

        listaEmpresa.add(emp1);
        listaEmpresa.add(emp2);
        listaEmpresa.add(emp3);
        listaEmpresa.add(emp4);
        listaEmpresa.add(emp5);
        listaEmpresa.add(emp6);
        listaEmpresa.add(emp7);
        listaEmpresa.add(emp8);
        listaEmpresa.add(emp9);
        listaEmpresa.add(emp10);

        final EmpresaRepository empresaRepository = EmpresaRepository.getInstance();
        empresaRepository.agregarEmpresa(emp1);
        empresaRepository.agregarEmpresa(emp2);
        empresaRepository.agregarEmpresa(emp3);
        empresaRepository.agregarEmpresa(emp4);
        empresaRepository.agregarEmpresa(emp5);
        empresaRepository.agregarEmpresa(emp6);
        empresaRepository.agregarEmpresa(emp7);
        empresaRepository.agregarEmpresa(emp8);
        empresaRepository.agregarEmpresa(emp9);
        empresaRepository.agregarEmpresa(emp10);



        adapter = new EmpresaAdapter(getActivity(), listaEmpresa);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,long id1) {

                final List<Empresa> empresas = empresaRepository.getEmpresas();
                Empresa empress = empresas.get(position);
                boolean nombrekey = false;
                Integer empresaId = empress.getId();
                for( Empresa empresa : empresas){
                    if(empresaId.equals(empresa.getId())){
                        nombrekey = true;
                    }
                    if(nombrekey){
                        rubro     = empresa.getRubro();
                        nombre    = empresa.getNombre();
                        direccion = empresa.getDireccion();
                        telefono  = empresa.getTelefono();
                        correo    = empresa.getCorreo();
                        url       = empresa.getUrl();
                        info      = empresa.getInfo();
                        logo      = empresa.getLogo();
                        id        = empresa.getId();
                        break;
                    }
                }

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("rubro", rubro);
                intent.putExtra("nombre", nombre);
                intent.putExtra("direccion", direccion);
                intent.putExtra("telefono", telefono);
                intent.putExtra("correo", correo);
                intent.putExtra("url", url);
                intent.putExtra("info", info);
                intent.putExtra("logo", logo);
                startActivity(intent);
            }
        });

        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return view;
    }
    public BuscarFragment getMainActivity(){
        return mainActivity;
    }

    public void setMain2Activity(BuscarFragment main2Activity){
        this.mainActivity = mainActivity;
    }
    }
