# Budget theme

Wrap application content and standalone previews in `BudgetTheme`.
Use `MaterialTheme.colorScheme` for semantic colors and
`MaterialTheme.typography` for text styles. `BudgetColors` exposes the raw palette.

The reference colors are Purple #9768FE, Black #000000 and Gray500 #666666.
Other shades extend the reference for light and dark surfaces. Dark text on the
primary purple is intentional for readable contrast. Error colors retain the
Material defaults.

Inter Tight comes from https://github.com/google/fonts/tree/main/ofl/intertight.
Static normal-style weights 400, 500, 600 and 700 were generated from the upstream
variable TTF using fonttools. Each file was checked for all Russian letters,
including Ё/ё, and the ruble symbol. Fonts are bundled for offline Android/iOS use.
The SIL OFL license is bundled in composeResources/files/licenses/InterTight-OFL.txt.
