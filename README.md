# 📅 NevnapGUI Projekt

Ez a JavaFX alkalmazás névnapokat jelenít meg egy `.csv` fájl alapján, hónap szerinti szűrési lehetőséggel.

## 📁 Bemeneti fájl: `nevnap.csv`

A fájl pontosvesszővel elválasztva, UTF-8 kódolással tartalmazza az adatokat:

név;nap1[;nap2;nap3...]

markdown
Kód másolása

> Egy névhez **több dátum** is tartozhat – a napok száma **változó**!

---

## ✅ Feladatok

### 1️⃣ Grafikus felület kialakítása *(2 pont)*

- Készítsük el a mintán látható GUI-t
- A **Fájl** menü tartalmazza:
  - **Megnyitás** (Ctrl + O)
  - **Kilépés** (Ctrl + Q)
- A ComboBox elemben legyen kiválasztható a hónap *(alap: Január)*
- A lista mérete: **500x300 px**, de **dinamikusan igazodjon az ablak méretéhez**
- Az elemek **ne érjenek össze vizuálisan**

---

### 2️⃣ Adatok betöltése és megjelenítése *(4 pont)*

- A **Megnyitás** menüpont fájlválasztóval betölt egy `.csv` fájlt *(1 pont)*
- Az adatok kerüljenek egy megfelelő adatszerkezetbe *(1 pont)*
- A kiválasztott hónap alapján szűrve, nap szerint növekvő sorrendben jelenjenek meg az adatok a listában *(2 pont)*

```java
// Fájlválasztó példa JavaFX-ben:
private FileChooser fc = new FileChooser();
fc.setInitialDirectory(new File("./"));
fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Szövegfájlok", "*.txt"));
File fbe = fc.showOpenDialog(lsLista.getScene().getWindow());
3️⃣ Hónapváltás és frissítés (2 pont)
Más hónap kiválasztása esetén azonnal frissüljön a lista (1 pont)

A hónapválasztó csak sikeres Megnyitás után legyen aktív (1 pont)

4️⃣ Súgó és Kilépés (2 pont)
A Súgó / Névjegy menüpont egy felugró ablakban jelenítsen meg információt (1 pont)

A Fájl / Kilépés menüpont zárja be az alkalmazást (1 pont)
