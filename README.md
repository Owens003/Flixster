# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).



📝 `NOTE` Collez ce modèle en haut de votre fichier `README.md` existant de la partie 1 de ce devoir. (🚫 Supprimez ce paragraphe après avoir coché les user stories terminées)

## Flix Partie 2

### Histoires d'utilisateurs

#### OBLIGATOIRE (10pts)

- [x] (8pts) Exposez les détails du film (notes à l'aide de RatingBar, popularité et synopsis) dans une activité distincte.
- [x] (2pts) Autoriser la lecture des publications vidéo en plein écran à l'aide de YouTubePlayerView.

#### PRIME

- [x] Implémenter une transition d'élément partagé lorsque l'utilisateur clique sur les détails d'un film (1 point).
- [x] Les bandes-annonces des films populaires sont lues automatiquement lorsque le film est sélectionné (1 point).
  - [x] Lorsque vous cliquez sur un film populaire (c'est-à-dire un film voté pour plus de 5 étoiles), la vidéo doit être lue immédiatement.
  - [x] Les vidéos moins populaires s'appuient sur la page détaillée doivent afficher un aperçu de l'image qui peut lancer la lecture d'une vidéo YouTube.
- [ ] Ajoutez une superposition d'icône de lecture aux films populaires pour indiquer que le film peut être lu (1 point).
- [x] Appliquer la liaison de données pour les vues pour aider à supprimer le code passe-partout. (1 point)
- [x] Ajoutez des coins arrondis pour les images en utilisant les transformations Glide. (1 point)

### App Walkthrough GIF

`TODO://` Ajoutez l'URL de votre application animée `gif` dans la balise d'image ci-dessous, `YOUR_GIF_URL_HERE`. Assurez-vous que le gif s'affiche et s'anime réellement lors de la visualisation de ce README. (🚫 Supprimez ce paragraphe après avoir ajouté le gif)

<img src="flixster.gif" width=250><br>

### Remarques

Décrivez les difficultés rencontrées lors de la création de l'application.

## Bibliothèques open-source utilisées
- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Requêtes HTTP asynchrones simples avec analyse JSON
- [Glide](https://github.com/bumptech/glide) - Bibliothèque de chargement et de mise en cache d'images pour Android

---
## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [x] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [x] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF

<img src="Walkthrough.gif" width=250><br>

### Notes
Describe any challenges encountered while building the app.

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
