package com.victorsaico.paginasamarrillas.repository;

import com.victorsaico.paginasamarrillas.model.Empresa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JARVIS on 28/09/2017.
 */

public class EmpresaRepository {
    private static EmpresaRepository _INSTANCE = null;

    private EmpresaRepository(){
    }

    public static EmpresaRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new EmpresaRepository();
        return _INSTANCE;
    }

    private List<Empresa> empresas = new ArrayList<Empresa>();

    public List<Empresa> getEmpresas(){
        return this.empresas;
    }

    public void agregarEmpresa(Empresa empresa){
        this.empresas.add(empresa);
    }


}
