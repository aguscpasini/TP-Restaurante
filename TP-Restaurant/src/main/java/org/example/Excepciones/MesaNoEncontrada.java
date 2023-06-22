package org.example.Excepciones;
    public class MesaNoEncontrada extends Exception{

        public MesaNoEncontrada(){};

        public MesaNoEncontrada (String msj_error){
            super (msj_error);
        }
    }

