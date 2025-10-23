# 🔹 Imagen base de Node.js para NestJS
FROM node:18-alpine

# 🔹 Establecer directorio de trabajo dentro del contenedor
WORKDIR /app

# 🔹 Copiar archivos de configuración de dependencias
COPY package*.json ./
COPY prisma ./prisma/

# 🔹 Instalar dependencias
RUN npm ci --only=production

# 🔹 Copiar el resto del código de la aplicación
COPY . .

# 🔹 Generar cliente de Prisma
RUN npx prisma generate

# 🔹 Construir la aplicación NestJS
RUN npm run build

# 🔹 Exponer el puerto (NestJS por defecto usa 3000)
EXPOSE 3000

# 🔹 Comando para ejecutar la aplicación
CMD ["npm", "run", "start:prod"]