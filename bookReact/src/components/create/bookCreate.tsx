import {
  Create,
  ReferenceInput,
  required,
  SelectInput,
  SimpleForm,
  TextInput,
  useCreate,
} from "react-admin";

export const BookCreate = () => {
  const [create] = useCreate();

  const onCreate = (data: any) => {
    create("books", { data: [data] });
  };

  return (
    <Create>
      <SimpleForm onSubmit={onCreate}>
        <TextInput source="title" validate={[required()]} label="Title" />
        <ReferenceInput source="category" reference="categories">
          <SelectInput optionText="name" label={"Category"} />
        </ReferenceInput>
        <ReferenceInput source="author" reference="authors">
          <SelectInput
            optionText={(record) => `${record.first_name} ${record.last_name}`}
            label={"Author"}
          />
        </ReferenceInput>
      </SimpleForm>
    </Create>
  );
};
