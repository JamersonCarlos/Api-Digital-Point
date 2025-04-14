import os

# Caminho da pasta
pasta = r"C:\Users\unive\OneDrive\Imagens\Fotos Escolhidas"

# Lista os arquivos da pasta
arquivos = os.listdir(pasta)

# Filtra apenas arquivos de imagem (você pode adicionar mais extensões se quiser)
extensoes_imagem = ('.jpg', '.jpeg', '.png', '.bmp', '.gif', '.tiff')

# Percorre os arquivos e exibe os nomes (códigos)
for arquivo in arquivos:
    if arquivo.lower().endswith(extensoes_imagem):
        nome = os.path.splitext(arquivo)[0]  # Remove a extensão
        print(nome)