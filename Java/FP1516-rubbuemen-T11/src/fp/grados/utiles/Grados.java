package fp.grados.utiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Grado;
import fp.grados.tipos.GradoImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.ProfesorImpl2;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.TipoBeca;
import fp.grados.tipos.TipoEspacio;
import fp.grados.tipos.Tutoria;

public class Grados {
	//Tipo Alumno:
	private static Set<Alumno> alumnos = new HashSet<>();
	
	private static void actualizaPoblacionales(Alumno a){
		alumnos.add(a);
	}
	
	public static Alumno createAlumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email){
		Alumno res = new AlumnoImpl(dni, nombre, apellidos, fechaNacimiento, email);
		actualizaPoblacionales(res);
		return res;
	}
	
	private static void copiaAsignaturasAlumno(Alumno res, Alumno a){
		for (Asignatura asig : a.getAsignaturas()) {
			res.matriculaAsignatura(asig);
		}
	}
	
	private static void copiaExpedienteAlumno(Alumno res, Alumno a){
		for (Nota n : a.getExpediente().getNotas()) {
			res.evaluaAlumno(n.getAsignatura(), n.getCursoAcademico(), n.getConvocatoria(), n.getValor(), n.getMencionHonor());
		}
	}
	
	public static Alumno createAlumno(Alumno a){
		Alumno res = new AlumnoImpl(a.getDNI(), a.getNombre(), a.getApellidos(), a.getFechaNacimiento(), a.getEmail());
		actualizaPoblacionales(res);
		copiaAsignaturasAlumno(res, a);
		copiaExpedienteAlumno(res, a);
		return res;
	}
	
	public static Alumno createAlumno(String a) {
		Alumno res = new AlumnoImpl(a);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static List<Alumno> createAlumnos(String nombreFichero) {
		List<Alumno> res = leeFichero(nombreFichero, s -> createAlumno(s));
		return res;
	}
	
	public static Integer getNumAlumnosCreados(){
		return alumnos.size();
	}
	
	public static Set<Alumno> getAlumnosCreados(){
		return new HashSet<>(alumnos);
	}
	
	//Tipo Asignatura:
	private static Map<String, Asignatura> asignaturasPorCodigo = new HashMap<>();
	
	private static void actualizaPoblacionales(Asignatura asig){
		asignaturasPorCodigo.put(asig.getCodigo(), asig);
	}
	
	public static Asignatura createAsignatura(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso, Departamento departamento){
		Asignatura res = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso, departamento);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static Asignatura createAsignatura(String asignatura){
		Asignatura res = new AsignaturaImpl(asignatura);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static List<Asignatura> createAsignaturas(String asignatura){
		List<Asignatura> res = leeFichero(asignatura, s -> createAsignatura(s));
		return res;
	}	
	
	public static Integer getNumAsignaturasCreadas(){
		return asignaturasPorCodigo.size();
	}
	
	public static Set<Asignatura> getAsignaturasCreadas(){
		return new HashSet<>(asignaturasPorCodigo.values());
	}
	
	public static Set<String> getCodigosAsignaturasCreadas(){
		return new HashSet<>(asignaturasPorCodigo.keySet());
	}
	
	public static Asignatura getAsignaturaCreada(String codigo){
		return asignaturasPorCodigo.get(codigo);
	}
	
	//Tipo Beca:	
	private static Set<Beca> becas = new HashSet<>();
	
	private static Integer[] numBecasPorTipo = {0, 0, 0};
	
	private static void actualizaPoblacionales(Beca beca){
		becas.add(beca);
		numBecasPorTipo[beca.getTipo().ordinal()]++;
	}
	
	public static Beca createBeca(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {
		Beca res = new BecaImpl(codigo, cuantiaTotal, duracion, tipo);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static Beca createBeca(String codigo, TipoBeca tipo) {
		Beca res = new BecaImpl(codigo, tipo);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static Beca createBeca(Beca b){
		Beca res = new BecaImpl(b.getCodigo(), b.getCuantiaTotal(), b.getDuracion(), b.getTipo());
		actualizaPoblacionales(res);
		return res;
	}
	
	public static Beca createBeca(String beca) {
		Beca res = new BecaImpl(beca);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static List<Beca> createBecas(String nombreFichero) {
		List<Beca> res = leeFichero(nombreFichero, s -> createBeca(s));
		return res;
	}
	
	public static Integer getNumBecasCreadas(){
		return becas.size();
	}
	
	public static Integer getNumBecasTipo(TipoBeca tipo){
		return numBecasPorTipo[tipo.ordinal()];
	}
	
	public static Set<Beca> getBecasCreadas(){
		return new HashSet<>(becas);
	}
	
	//Tipo Centro
	private static Set<Centro> centros = new HashSet<>();
	
	private static Integer numMaxPlantas = null;
	
	private static Integer numMaxSotanos = null;
	
	private static Double numPlantas = 0.0;
	
	private static Double numSotanos = 0.0;
	
	private static void actualizaPoblacionales(Centro c){
		centros.add(c);
		if(numMaxPlantas== null || c.getNumeroPlantas() > numMaxPlantas){
			numMaxPlantas = c.getNumeroPlantas();
		}
		if(numMaxSotanos == null || c.getNumeroSotanos() > numMaxSotanos){
			numMaxSotanos = c.getNumeroSotanos();
		}
		numPlantas = numPlantas + c.getNumeroPlantas();
		numSotanos = numSotanos + c.getNumeroSotanos();
	}
	
	public static Centro createCentro(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos){
		Centro res = new CentroImpl(nombre, direccion, numeroPlantas, numeroSotanos);
		actualizaPoblacionales(res);
		return res;
	}
	
	private static void copiaEspaciosCentro(Centro res, Centro c){
		for (Espacio es : c.getEspacios()) {
			res.nuevoEspacio(es);
		}
	}
	
	public static Centro createCentro(Centro c){
		Centro res = new CentroImpl(c.getNombre(), c.getDireccion(), c.getNumeroPlantas(), c.getNumeroSotanos());
		actualizaPoblacionales(res);
		copiaEspaciosCentro(res, c);
		return res;
	}
	
	public static Integer getNumCentrosCreados(){
		return centros.size();
	}
	
	public static Set<Centro> getCentrosCreados(){
		return new HashSet<>(centros);
	}
	
	public static Integer getMaxPlantas(){
		return numMaxPlantas;
	}
	
	public static Integer getMaxSotanos(){
		return numMaxSotanos;
	}
	
	public static Double getMediaPlantas(){
		if(getNumCentrosCreados() == 0){
			return numPlantas;
		}
		else{
			return numPlantas/getNumCentrosCreados();
		}
	}
	
	public static Double getMediaSotanos(){
		if(getNumCentrosCreados() == 0){
			return numSotanos;
		}
		else{
			return numSotanos/getNumCentrosCreados();
		}
	}
	
	//Tipo Departamento:
	private static Set<Departamento> departamentos = new HashSet<>();
	
	private static void actualizaPoblacionales(Departamento dep){
		departamentos.add(dep);
	}
	
	public static Departamento createDepartamento(String nombre){
		Departamento res = new DepartamentoImpl(nombre);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static Integer getNumDepartamentosCreados() {
		return departamentos.size();
	}
	
	public static Set<Departamento> getDepartamentosCreados() {
		return new HashSet<>(departamentos);
	}
	
	//Tipo Despacho:
	private static Set<Espacio> espacios = new HashSet<>();
	
	private static void actualizaPoblacionales(Despacho des){
		espacios.add(des);
	}
	
	public static Despacho createDespacho(String nombre, Integer capacidad, Integer planta){
		Despacho res = new DespachoImpl(nombre, capacidad, planta);
		actualizaPoblacionales(res);
		return res;
	}
	
	private static void copiaProfesoresDespacho(Despacho res, Despacho des){
		res.setProfesores(des.getProfesores());
	}
	
	public static Despacho createDespacho(Despacho des){
		Despacho res = new DespachoImpl(des.getNombre(), des.getCapacidad(), des.getPlanta());
		actualizaPoblacionales(res);
		copiaProfesoresDespacho(res, des);
		return res;
	}
	
	public static Despacho createDespacho(String despacho){
		Despacho res = new DespachoImpl(despacho);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static List<Despacho> createDespachos(String nombreFichero) {
		List<Despacho> res = leeFichero(nombreFichero, s -> createDespacho(s));
		return res;
	}
	
	//Tipo Espacio
	private static Integer plantaMayorEspacio = null;
	
	private static Integer plantaMenorEspacio = null;

	private static void actualizaPoblacionales(Espacio es){
		espacios.add(es);
		if(plantaMayorEspacio == null || es.getPlanta() > plantaMayorEspacio){
			plantaMayorEspacio = es.getPlanta();
		}
		if(plantaMenorEspacio == null || es.getPlanta() < plantaMenorEspacio){
			plantaMenorEspacio = es.getPlanta();
		}
	}
	
	public static Espacio createEspacio(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta){
		Espacio res = new EspacioImpl(tipo, nombre, capacidad, planta);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static Espacio createEspacio(Espacio es){
		Espacio res = new EspacioImpl(es.getTipo(), es.getNombre(), es.getCapacidad(), es.getPlanta());
		actualizaPoblacionales(res);
		return res;
	}
	
	public static Espacio createEspacio(String espacio){
		Espacio res = new EspacioImpl(espacio);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static List<Espacio> createEspacios(String nombreFichero) {
		List<Espacio> res = leeFichero(nombreFichero, s -> createEspacio(s));
		return res;
	}
	
	public static Integer getNumEspaciosCreados(){
		return espacios.size();
	}
	
	public static SortedSet<Espacio> getEspaciosCreados(){
		return new TreeSet<>(espacios);
	}
	
	public static Integer getPlantaMayorEspacio(){
		return plantaMayorEspacio;
	}
	
	public static Integer getPlantaMenorEspacio(){
		return plantaMenorEspacio;
	}
	
	//Tipo Grado:
	private static Set<Grado> grados = new HashSet<>();
	
	private static Double numAsignaturasOptativas = 0.0;
	
	private static Double numAsignaturasObligatorias = 0.0;
	
	private static Double numAsignaturas = 0.0;
	
	private static void actualizaPoblacionales(Grado g){
		grados.add(g);
		numAsignaturasOptativas = numAsignaturasOptativas + g.getAsignaturasOptativas().size();
		numAsignaturasObligatorias = numAsignaturasObligatorias + g.getAsignaturasObligatorias().size();
		numAsignaturas = numAsignaturas + g.getAsignaturasOptativas().size() + g.getAsignaturasObligatorias().size();
	}
	
	public static Grado createGrado(String nombre, Set<Asignatura> asignaturasObligatorias, Set<Asignatura> asignaturasOptativas, Double numeroMinimoCreditosOptativas){
		Grado res = new GradoImpl(nombre, asignaturasObligatorias, asignaturasOptativas, numeroMinimoCreditosOptativas);
		actualizaPoblacionales(res);
		return res;
	}
	
	public static Integer getNumGradosCreados(){
		return grados.size();
	}
	
	public static Set<Grado> getGradosCreados(){
		return new HashSet<>(grados);
	}
	
	public static Double getMediaAsignaturasObligatoriasGrados(){
		if(getNumGradosCreados() == 0){
			return numAsignaturasObligatorias;
		}
		else{
			return numAsignaturasObligatorias/getNumGradosCreados();
		}
	}

	public static Double getMediaAsignaturasOptativasGrados(){
		if(getNumGradosCreados() == 0){
			return numAsignaturasOptativas;
		}
		else{
			return numAsignaturasOptativas/getNumGradosCreados();
		}
	}
	
	public static Double getMediaAsignaturasGrados(){
		if(getNumGradosCreados() == 0){
			return numAsignaturas;
		}
		else{
			return numAsignaturas/getNumGradosCreados();
		}
	}	
	
	//Tipo Profesor:
	private static Boolean usarImplementacionMap = true;
	private static Set<Profesor> profesores = new HashSet<>();
	
	private static void actualizaPoblacionales(Profesor pr){
		profesores.add(pr);
	}
	
	public static void setUsarImplementacionMapProfesor(Boolean b){
		usarImplementacionMap = b;
	}
	
	public static Profesor createProfesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Categoria categoria, Departamento departamento){
		Profesor res = null;
		if(usarImplementacionMap){
			res = new ProfesorImpl2(dni, nombre, apellidos, fechaNacimiento, email, categoria, departamento);
		}
		else{
			res = new ProfesorImpl(dni, nombre, apellidos, fechaNacimiento, email, categoria, departamento);
		}
		actualizaPoblacionales(res);
		return res;
	}
	
	private static void copiaAsignaturasProfesor(Profesor res, Profesor pr){
		for (Asignatura asig : pr.getAsignaturas()) {
			res.imparteAsignatura(asig, pr.dedicacionAsignatura(asig));
		}
	}
	
	private static void copiaTutoriasProfesor(Profesor res, Profesor pr){
		for (Tutoria t : pr.getTutorias()) {
			res.nuevaTutoria(t.getHoraComienzo(), t.getDuracion(),t.getDiaSemana());
		}
	}
	
	public static Profesor createProfesor(Profesor profesor){
		Profesor res = createProfesor(profesor.getDNI(), profesor.getNombre(), profesor.getApellidos(), profesor.getFechaNacimiento(), profesor.getEmail(), profesor.getCategoria(), profesor.getDepartamento());
		copiaAsignaturasProfesor(res, profesor);
		copiaTutoriasProfesor(res, profesor);
		return res;
	}
	
	public static Integer getNumProfesoresCreados() {
		return profesores.size();
	}
	
	public static Set<Profesor> getProfesoresCreados() {
		return new HashSet<>(profesores);
	}	

	//Método auxiliar para leer ficheros	
	public static <T> List<T> leeFichero(String nombreFichero, Function<String,T> funcion_deString_aT){
		List<T> res = null;
		try {
			res = Files.lines(Paths.get(nombreFichero)).map(funcion_deString_aT).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Error en lectura del fichero: " + nombreFichero);
		}
		return res;
	}
}