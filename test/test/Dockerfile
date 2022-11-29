FROM node:16.14.0-alpine
# create destination directory
RUN mkdir -p /test
WORKDIR /test
# copy the app, note .dockerignore
COPY . /test/
RUN npm i
RUN npm run build
# start the app
CMD [ "npm", "start" ]