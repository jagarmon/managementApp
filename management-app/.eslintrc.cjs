module.exports = {
    "env": {
        "browser": true,
        "es2021": true
    },
    "settings": {
        "react": {
          "version": "detect", // React version. "detect" automatically picks the version you have installed.
                               // You can also use `16.0`, `16.3`, etc, if you want to override the detected value.
                               // It will default to "latest" and warn if missing, and to "detect" in the future
        },
    },    
    "extends": [
        "eslint:recommended",
        "plugin:react/recommended"
    ],
    "parser": '@typescript-eslint/parser',    
    "overrides": [
        {
            "env": {
                "node": true
            },
            "files": [
                ".eslintrc.{js,cjs}"
            ],
            "parserOptions": {
                "sourceType": "script"
            }
        }
    ],
    "parserOptions": {
        "ecmaVersion": "latest",
        "sourceType": "module"
    },
    "plugins": [
        '@typescript-eslint',
        "react"
    ],
    "rules": {
        "react/react-in-jsx-scope": "off",
        "react/jsx-uses-react": "off",
        "@typescript-eslint/no-explicit-any": "error",
        "@typescript-eslint/no-duplicate-enum-values": "error",
        "@typescript-eslint/no-namespace": "error",
        "@typescript-eslint/no-unused-vars": "error",
        "@typescript-eslint/prefer-as-const": "error",      

    }
}
