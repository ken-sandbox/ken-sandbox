# ユニットテスト（JUnit）実行手順

このプロジェクトは **JUnit 4** フレームワークを使用したユニットテストを含みます。

## 前提条件

- Java 8 以上
- Gradle（または gradlew）

## テスト実行方法

### Windows PowerShell

```powershell
# プロジェクトルートへ移動
Set-Location 'C:\Users\pyqjg\OneDrive\デスクトップ\app_dev\android-app'

# ユニットテストを実行
.\gradlew.bat test

# 詳細情報を含めて実行
.\gradlew.bat test --info

# 特定のテストクラスのみを実行
.\gradlew.bat test --tests GreetingUtilTest
```

### macOS / Linux

```bash
cd ~/Desktop/app_dev/android-app

# ユニットテストを実行
./gradlew test

# 特定のテストクラスのみを実行
./gradlew test --tests GreetingUtilTest
```

## テスト内容

### `GreetingUtilTest.kt`

`GreetingUtil` クラスのテスト。以下のメソッドをテストしています：

#### `greet()` メソッド
- `greet_withValidName_returnsGreetingWithName()` — 名前を入力したときに "Hello, {name}!" が返されることを確認
- `greet_withEmptyName_returnsDefaultGreeting()` — 空文字列で "Hello, World!" が返されることを確認
- `greet_withBlankName_returnsDefaultGreeting()` — 空白文字列で "Hello, World!" が返されることを確認

#### `isValidName()` メソッド
- `isValidName_withValidName_returnsTrue()` — 有効な名前で true が返されることを確認
- `isValidName_withEmptyName_returnsFalse()` — 空文字列で false が返されることを確認
- `isValidName_withBlankName_returnsFalse()` — 空白文字列で false が返されることを確認

#### `countWords()` メソッド
- `countWords_withSimpleMessage_returnsCorrectCount()` — 単語数を正しくカウント
- `countWords_withMultipleWords_countsCorrectly()` — 複数単語をカウント
- `countWords_withExtraSpaces_handlesCorrectly()` — 余分な空白を適切に処理
- `countWords_withEmptyString_returnsZero()` — 空文字列で 0 を返す

## テスト結果の確認

テスト実行後、結果は以下の場所に出力されます：

```
app/build/outputs/unit_test_results/
```

HTML レポートも生成されます：

```
app/build/reports/tests/testDebugUnitTest/index.html
```

## テスト失敗時のデバッグ

```powershell
# スタックトレース付きで実行
.\gradlew.bat test --stacktrace

# デバッグ情報付きで実行
.\gradlew.bat test --debug
```

## 参考資料

- [JUnit 4 Documentation](https://junit.org/junit4/)
- [Android Unit Testing Guide](https://developer.android.com/training/testing/unit-testing)
