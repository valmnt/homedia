# <img src="assets/logo.png" width="30"> media_server_docker

<img src="assets/banner.png">

> This project aims to establish a home media server that allows you to watch your favorite movies and TV shows for free. It leverages a suite of tools, all deployed using Docker, to create a comprehensive solution for managing and streaming media content 🍿.

---

Here's a brief overview of each component and its role in the setup:

- **Jellyfin**: An open-source media server that organizes, manages, and streams your media. Jellyfin serves as the core interface where you can browse your collection of movies, TV shows, music, and photos from any device. (https://github.com/jellyfin/jellyfin)

<br />

- **Jackett**: Acts as a proxy server that integrates with various torrent search engines to fetch media content. Jackett is essential for finding and downloading content through torrent files and magnet links. (https://github.com/Jackett/Jackett)

<br />

- **Deluge**: A lightweight, cross-platform BitTorrent client used for downloading the media files found by Jackett. It's known for its efficiency and extensive plugin support. (https://github.com/deluge-torrent/deluge)

<br />

- **Sonarr**: Specializes in managing TV shows. Sonarr automates the process of searching for, downloading, and organizing TV episodes. It integrates seamlessly with both Jackett for searching and Deluge for downloading. (https://github.com/Sonarr/Sonarr)

<br />

- **Radarr**: Similar to Sonarr but focused on movies. Radarr simplifies the process of tracking your favorite films, automatically downloading new releases, and organizing them within your collection. (https://github.com/Radarr/Radarr)

---

*All these tools are orchestrated via Docker, making deployment and management straightforward. This Docker-based media server project offers a robust, versatile, and user-friendly way to enjoy a personal cinema experience at home.*

*🚨 Please note that configuring these tools requires specific steps. For detailed guidance, consider watching instructional videos, where experts often share step-by-step tutorials tailored to various proficiency levels.*

<br />

> *support@nexhub.fr*