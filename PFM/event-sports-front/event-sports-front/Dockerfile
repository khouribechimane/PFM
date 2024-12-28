# Étape 1: Construction du projet avec Node.js
FROM node:22.11.0-alpine AS builder
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# Étape 2: Utilisation de Nginx pour servir l'application
FROM nginx:alpine
# Copie des fichiers générés par React dans le répertoire de Nginx
COPY --from=builder /app/build /usr/share/nginx/html
