# UIテスト（Espresso）実行手順

このプロジェクトは **Espresso** フレームワークを使用した UI テストを含みます。

## 前提条件

- Android SDK がインストール済み（API 21 以上）
- Android エミュレータまたは実機が接続されていること
- Java 8 以上

## テスト実行方法

### Windows PowerShell

```powershell
# プロジェクトルートへ移動
Set-Location 'C:\Users\pyqjg\OneDrive\デスクトップ\app_dev\android-app'

# エミュレータを起動（必要な場合）
# emulator -avd <avd_name> &

# UI テストを実行
.\gradlew.bat connectedAndroidTest

# または、デバッグビルドの後に UI テストを実行
.\gradlew.bat connectedAndroidTest --info
```

### macOS / Linux

```bash
cd ~/Desktop/app_dev/android-app
./gradlew connectedAndroidTest
```

## テストの説明

### `MainActivityTest.kt`

- **testHelloTextViewIsDisplayed**: TextViewが画面に表示されていることを確認
- **testHelloTextContent**: TextViewに内容（テキスト）が存在することを確認

テストは端末のロケール設定に応じて以下の言語リソースを自動で確認します：
- デフォルト（英語）: `Hello, World!`
- 日本語: `こんにちは、世界！`
- 中国語（簡体字）: `你好，世界！`

## テスト結果の確認

テスト実行後、以下の場所に結果が出力されます：

```
app/build/outputs/androidTest-results/connected/
```

HTML レポートも生成されます：

```
app/build/reports/androidTests/connected/index.html
```

## トラブルシューティング

### エミュレータが起動しない場合

```powershell
# インストール済みの AVD を確認
emulator -list-avds

# 特定の AVD を起動
emulator -avd Pixel_4_API_33 -no-audio &
```

### テストが找不到 MainActivity の場合

`app/src/main/AndroidManifest.xml` にアクティビティが正しく登録されていることを確認してください。

### 依存性エラー

```powershell
# キャッシュをクリアしてリビルド
.\gradlew.bat clean connectedAndroidTest
```

## 参考資料

- [Espresso Testing Framework](https://developer.android.com/training/testing/espresso)
- [Android Testing Guide](https://developer.android.com/training/testing)
