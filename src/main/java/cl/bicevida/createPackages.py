import os
import shutil

def move_java_files(source_dir, destination_dir):
    for root, _, files in os.walk(source_dir):
        for file in files:
            if file.endswith('.java'):
                source_file = os.path.join(root, file)
                destination_file = os.path.join(destination_dir, file)
                if not os.path.exists(destination_file):
                    shutil.move(source_file, destination_file)
                    print(f"Java file '{file}' moved to 'domain.modelo' package.")

def create_package_structure(base_dir):
    packages = ['application', 'domain', 'infrastructure', 'utils']
    subpackages = {
        'application': ['rutas', 'controladores'],
        'domain': ['DTO', 'modelo', 'puertoEntrada', 'puertoSalida']
    }

    try:
        for package in packages:
            package_path = os.path.join(base_dir, package)
            if not os.path.exists(package_path):
                os.makedirs(package_path)
                print(f"Package '{package}' created.")

            if package in subpackages:
                for subpackage in subpackages[package]:
                    subpackage_path = os.path.join(package_path, subpackage)
                    os.makedirs(subpackage_path, exist_ok=True)
                    print(f"Subpackage '{subpackage}' created inside '{package}'.")

                    if subpackage == 'modelo':
                        source_dir = os.path.join(base_dir, 'domain', 'modelo')
                        move_java_files(source_dir, subpackage_path)

    except OSError as e:
        print(f"Error creating package: {e}")

if __name__ == "__main__":
    input_path = input("Path donde generar los packages : ")
    create_package_structure(input_path)
