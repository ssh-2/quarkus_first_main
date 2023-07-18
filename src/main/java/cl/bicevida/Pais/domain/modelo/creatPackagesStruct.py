import os
import re

def crear_paquete(nombre_archivo):
    nombre_clase = re.sub(r'\.java$', '', nombre_archivo)
    nombre_paquete = re.sub(r'_Modelo$', '', nombre_clase)
    directorios = nombre_paquete.split('.')
    ruta_paquete = os.path.join(*directorios)
    os.makedirs(ruta_paquete, exist_ok=True)

    subpaquetes = {
        'application': ['controladores', 'rutas'],
        'domain': ['modelo', 'puertoEntrada', 'puertoSalida'],
        'infrastructure': []
    }
    for paquete_padre, subpaquetes_hijos in subpaquetes.items():
        ruta_paquete_padre = os.path.join(ruta_paquete, paquete_padre)
        os.makedirs(ruta_paquete_padre, exist_ok=True)
        for subpaquete in subpaquetes_hijos:
            ruta_subpaquete = os.path.join(ruta_paquete_padre, subpaquete)
            os.makedirs(ruta_subpaquete, exist_ok=True)

    ruta_clase_origen = os.path.join(os.getcwd(), nombre_archivo)
    ruta_clase_destino = os.path.join(ruta_paquete, 'domain', 'modelo', nombre_archivo)
    os.rename(ruta_clase_origen, ruta_clase_destino)

    with open(ruta_clase_destino, 'r+') as archivo_clase:
        contenido = archivo_clase.read()
        archivo_clase.seek(0)
        archivo_clase.write(f'package {nombre_paquete}.domain.modelo;\n{contenido}')

archivos_java = [archivo for archivo in os.listdir('.') if archivo.endswith('.java')]
for archivo in archivos_java:
    crear_paquete(archivo)
